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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
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
    public Brand findByIdBrand(Long id_brand) {
        Brand brand = brandRespository.findByIdBrand(id_brand);
        return brand;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Brand findByBrand(Long numeroBrand) {
        Brand brand = brandRespository.findByBrand(numeroBrand);
        return brand;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Brand> findAll() {
        List<Brand> brand = new ArrayList<>();
        brandRespository.findAll().forEach(brand::add);
        return brand;
    }

    @Transactional
    public BrandTemplate mergeBrand (BrandTemplate brandTemplate, Long idBrand){
        log.info("[CARDVALIDATOR] -altera brand");

        Brand brandModel = this.brandRespository.findById(idBrand).orElseThrow(() -> new EntityNotFoundException(idBrand.toString()));
        BrandTemplateToBrandModel.MAPPER.updateBinFromBrandTemplate(brandTemplate, brandModel);

        return BrandModelToBrandTemplate.MAPPER.brandTemplateMapper(brandRespository.save(brandModel));

    }

}
