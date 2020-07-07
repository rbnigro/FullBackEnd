package br.com.linx.cardValidator.services;

import br.com.linx.cardValidator.mapper.BinModelToBinTemplate;
import br.com.linx.cardValidator.mapper.BinTemplateToBinModel;
import br.com.linx.cardValidator.mapper.BrandModelToBrandTemplate;
import br.com.linx.cardValidator.mapper.BrandTemplateToBrandModel;
import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.repository.BrandRespository;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BrandTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BrandServer {

    @Autowired
    private BrandRespository brandRespository;

    public BrandTemplate saveBrand (BrandTemplate brandTemplate){

        log.info("[CARDVALIDATOR] -saving brand");
        Brand brandModel= brandRespository.save(BrandTemplateToBrandModel.MAPPER.brandMapper(brandTemplate));
        return BrandModelToBrandTemplate.MAPPER.brandTemplateMapper(brandModel);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Brand> findAll() {
        List<Brand> brand = new ArrayList<>();
        brandRespository.findAll().forEach(brand::add);
        return brand;
    }

}
