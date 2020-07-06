package br.com.linx.cardValidator.services;

import br.com.linx.cardValidator.mapper.BinModelToBinTemplate;
import br.com.linx.cardValidator.mapper.BinTemplateToBinModel;
import br.com.linx.cardValidator.mapper.BinTypeModelToBinTypeTemplate;
import br.com.linx.cardValidator.mapper.BinTypeTemplateToBinTypeModel;
import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.repository.BinTypeRepository;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
