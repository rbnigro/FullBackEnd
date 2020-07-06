package br.com.linx.cardValidator.mapper;

import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BinTypeTemplateToBinTypeModel {

    BinTypeTemplateToBinTypeModel MAPPER = Mappers.getMapper(BinTypeTemplateToBinTypeModel.class);
    Bin binTypeMapper (BinTypeTemplate binTypeTemplate);

}
