package br.com.linx.cardValidator.services;

import br.com.linx.cardValidator.dto.BinDTO;
import br.com.linx.cardValidator.dto.BinErrorDTO;
import br.com.linx.cardValidator.dto.BinTemplates;
import br.com.linx.cardValidator.mapper.BinModelToBinTemplate;
import br.com.linx.cardValidator.mapper.BinTemplateToBinModel;
import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.repository.BinRepository;
import br.com.linx.cardValidator.repository.BinTypeRepository;
import br.com.linx.cardValidator.repository.BrandRespository;
import br.com.linx.cardValidator.templates.BinTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BinServer {

    @Autowired
    private BinRepository binRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BrandRespository brandRespository;

    @Autowired
    private BinTypeRepository binTypeRepository;

    //inclusao unitaria
    public BinTemplate saveBin (BinTemplate binTemplate) throws Exception{
        log.info("[CARDVALIDATOR] -saving bin");


        if (binTemplate.getCreatedAt()==null){
            binTemplate.setCreatedAt(LocalDateTime.now());
        }
        Bin binModel = BinTemplateToBinModel.MAPPER.binMapper(binTemplate);
        binModel.setBrand(brandRespository.findByIdBrand(binTemplate.getIdBrand()));

        if(binModel.getBrand()==null) {
            throw new Exception("message: id_brand not found");
        }

        Optional<BinType> binTypeModel = this.binTypeRepository.findById(binTemplate.getIdType());
        if (!binTypeModel.isPresent()){
            throw  new Exception("id type not found");
        }
        binModel.setLinkedBinTypes(new HashSet<>());
        binModel.getLinkedBinTypes().add(binTypeModel.get());
        binModel = binRepository.save(binModel);

        return BinModelToBinTemplate.MAPPER.binTemplateMapper(binModel);

    }

    public BinTemplates saveBin (List<BinTemplate> binTemplate) throws Exception{
        log.info("[CARDVALIDATOR] -saving bin");
        List<BinErrorDTO> binErrorDTOs = new ArrayList<>();
        List<Bin> binModels = binTemplate
                .stream()
                .map(element ->
                    BinTemplateToBinModel.MAPPER.binMapper(element)
                )
                .collect(Collectors.toList());
        for (BinTemplate element : binTemplate) {
            for (int i =0; i < binModels.size(); i++) {
                if (binModels.get(i).getBin().equals(element.getBin())){
                    binModels.get(i).setLinkedBinTypes(new HashSet<>());
                    if(element.getIdType() != null)
                        binModels.get(i).getLinkedBinTypes().add(this.binTypeRepository.findById(element.getIdType()).get());
                    else {
                        if(binModels.size() == 1) {
                            throw new Exception("Id type not found");
                        }
                        binModels.remove(binModels.get(i));
                        binErrorDTOs.add(new BinErrorDTO("Id type not Found ", BinModelToBinTemplate.MAPPER.binTemplateMapper(binModels.get(i))));
                    }
                }
            }
        }

        binModels.forEach(element-> {
            if(element.getBrand() ==null) {
                binModels.remove(element);
                binErrorDTOs.add(new BinErrorDTO("Id Brand not Found ", BinModelToBinTemplate.MAPPER.binTemplateMapper(element)));
            }
        });

        List<Bin> binModels_ = binRepository.saveAll(binModels);
        List<BinTemplate> binTemplatesSuccess = binModels_.stream().map(element -> BinModelToBinTemplate.MAPPER.binTemplateMapper(element)).collect(Collectors.toList());
        return new BinTemplates(binTemplatesSuccess, binErrorDTOs ) ;
    }

    //alteracao mod 1
    @Transactional
    public BinTemplate mergeBin (BinTemplate binTemplate, Long idBin){
        log.info("[CARDVALIDATOR] -saving bin");

        Bin binModel = this.binRepository.findById(idBin).orElseThrow(() -> new EntityNotFoundException(idBin.toString()));
        BinTemplateToBinModel.MAPPER.updateBinFromBinTemplate(binTemplate, binModel);

        return BinModelToBinTemplate.MAPPER.binTemplateMapper(binRepository.save(binModel));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        binRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Bin findByIdBin(Long id_bin) {
        Bin bin = binRepository.findByIdBin(id_bin);
        return bin;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BinDTO findByBin(Long numeroBin, String tipo) {
        BinDTO binDTO =  binRepository.findByBin(numeroBin);
        binDTO.setPaymentTypeIsValid(!(tipo == null || tipo.isEmpty()) ? (tipo.equals(binDTO.getDescType())) : true);
        return binDTO;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Bin> findAll(Pageable pageable) {
        List<Bin> bins = new ArrayList<>();
        binRepository.findAll(pageable).forEach(bins::add);
        return bins;
    }

   @Transactional
    public boolean markEntryAsRead (Long idBin, String status){
         int return_ = binRepository.markEntryAsRead(idBin, status);
         log.info("UPDATE REALIZADO " + return_);
         return return_==1;
    }

    private Brand getBrand(Long idbrand) {
        Optional<Brand> brand = this.brandRespository.findById(idbrand);
        if (brand.isPresent())
            return brand.get();

        return null;
    }
}
