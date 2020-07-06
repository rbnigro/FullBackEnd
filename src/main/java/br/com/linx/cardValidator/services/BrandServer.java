package br.com.linx.cardValidator.services;

import br.com.linx.cardValidator.mapper.BinModelToBinTemplate;
import br.com.linx.cardValidator.mapper.BinTemplateToBinModel;
import br.com.linx.cardValidator.mapper.BrandModelToBrandTemplate;
import br.com.linx.cardValidator.mapper.BrandTemplateToBrandModel;
import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.repository.BrandRespository;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BrandTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandServer {

    @Autowired
    private BrandRespository brandRespository;


    public BrandTemplate saveBrand (BrandTemplate brandTemplate){

        log.info("[CARDVALIDATOR] -saving brand");
        Brand brandModel=
                brandRespository.save(BrandTemplateToBrandModel.MAPPER.brandMapper(brandTemplate));
        return BrandModelToBrandTemplate.MAPPER.brandTemplateMapper(brandModel);
    }




}
