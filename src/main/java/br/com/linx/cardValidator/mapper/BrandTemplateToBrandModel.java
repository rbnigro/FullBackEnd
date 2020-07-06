package br.com.linx.cardValidator.mapper;

import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.templates.BrandTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandTemplateToBrandModel {

    BrandTemplateToBrandModel MAPPER = Mappers.getMapper(BrandTemplateToBrandModel.class);
    Brand brandMapper (BrandTemplate brandTemplate);

}
