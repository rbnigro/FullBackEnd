package br.com.linx.cardValidator.mapper;


import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BinTypeModelToBinTypeTemplate {

    BinTypeModelToBinTypeTemplate MAPPER = Mappers.getMapper(BinTypeModelToBinTypeTemplate.class);
    BinTypeTemplate binTypeTemplateMapper (BinType binTypeModel);
}
