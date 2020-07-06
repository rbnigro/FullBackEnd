package br.com.linx.cardValidator.mapper;


import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.templates.BinTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BinTypeModelToBinTypeTemplate {

    BinTypeModelToBinTypeTemplate MAPPER = Mappers.getMapper(BinTypeModelToBinTypeTemplate.class);
    BinTemplate binTypeTemplateMapper (BinType binTypeModel);
}
