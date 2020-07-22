package br.com.linx.cardValidator.services;

import br.com.linx.cardValidator.dto.BinDTO;
import br.com.linx.cardValidator.mapper.BinModelToBinTemplate;
import br.com.linx.cardValidator.mapper.BinTemplateToBinModel;
import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.repository.BinRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        binModel = binRepository.save(binModel);
        return BinModelToBinTemplate.MAPPER.binTemplateMapper(binModel);

    }

    public List<BinTemplate> saveBin (List<BinTemplate> binTemplate){
        log.info("[CARDVALIDATOR] -saving bin");
        List<Bin> binModels = binTemplate
                .stream()
                .map(element ->
                    BinTemplateToBinModel.MAPPER.binMapper(element)
                )
                .collect(Collectors.toList());

        binModels.forEach(element-> {
            element.setBrand(getBrand(element.getBrand().getIdBrand()));
            if(element.getBrand() ==null) {
                binModels.remove(element);
            }
        });

        List<Bin> binModels_ = binRepository.saveAll(binModels);
        return binModels_.stream().map(element -> BinModelToBinTemplate.MAPPER.binTemplateMapper(element)).collect(Collectors.toList());
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
    public BinDTO findByBin(Long numeroBin) {
        BinDTO binDTO =  binRepository.findByBin(numeroBin);
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
