package br.com.linx.cardValidator.mapper;

import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BrandTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(nullValueCheckStrategy = ALWAYS)
public interface BrandTemplateToBrandModel {

    BrandTemplateToBrandModel MAPPER = Mappers.getMapper(BrandTemplateToBrandModel.class);
    Brand brandMapper (BrandTemplate brandTemplate);

    void updateBinFromBrandTemplate(BrandTemplate template, @MappingTarget Brand brandModel);

}
