package br.com.linx.cardValidator.services;

import br.com.linx.cardValidator.mapper.*;
import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.repository.BinTypeRepository;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import br.com.linx.cardValidator.templates.BrandTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BinTypeServer {

    @Autowired
    private BinTypeRepository binTypeRepository;



    public BinTypeTemplate saveBinType (BinTypeTemplate binTypeTemplate){

        log.info("[CARDVALIDATOR] -saving BinType");
        BinType binTypeModel =
        binTypeRepository.save(BinTypeTemplateToBinTypeModel.MAPPER.binTypeMapper(binTypeTemplate));
        return BinTypeModelToBinTypeTemplate.MAPPER.binTypeTemplateMapper(binTypeModel);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<BinType> findAll() {
        List<BinType> binsType = new ArrayList<>();
        binTypeRepository.findAll().forEach(binsType::add);
        return binsType;
    }


   @Transactional
   public BinTypeTemplate mergeType (BinTypeTemplate binTypeTemplate, Long idType){
       log.info("[CARDVALIDATOR] -altera type");

       BinType binTypeModel = this.binTypeRepository.findById(idType).orElseThrow(() -> new EntityNotFoundException(idType.toString()));
       BinTypeTemplateToBinTypeModel.MAPPER.updateBinTypeFromBinTypeTemplate(binTypeTemplate, binTypeModel);

       return BinTypeModelToBinTypeTemplate.MAPPER.binTypeTemplateMapper(binTypeRepository.save(binTypeModel));

   }


}
