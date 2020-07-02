package br.com.linx.cardValidator.mapper;

import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.templates.BinTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BinModelToBinTemplate {

    BinModelToBinTemplate MAPPER = Mappers.getMapper(BinModelToBinTemplate.class);
    BinTemplate binTemplateMapper (Bin binModel);

}
