package br.com.linx.cardValidator.mapper;


import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BinTypeTemplateToBinTypeModel {

    BinTypeTemplateToBinTypeModel MAPPER = Mappers.getMapper(BinTypeTemplateToBinTypeModel.class);
    BinType binTypeMapper (BinTypeTemplate binTypeTemplate);

}
