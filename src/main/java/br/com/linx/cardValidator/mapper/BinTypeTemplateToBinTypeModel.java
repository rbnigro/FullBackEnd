package br.com.linx.cardValidator.mapper;


import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(nullValueCheckStrategy = ALWAYS)
public interface BinTypeTemplateToBinTypeModel {

    BinTypeTemplateToBinTypeModel MAPPER = Mappers.getMapper(BinTypeTemplateToBinTypeModel.class);
    BinType binTypeMapper (BinTypeTemplate binTypeTemplate);

    void updateBinTypeFromBinTypeTemplate(BinTypeTemplate template, @MappingTarget BinType binTypeModel);

}
