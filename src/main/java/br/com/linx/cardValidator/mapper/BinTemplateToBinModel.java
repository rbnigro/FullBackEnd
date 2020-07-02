package br.com.linx.cardValidator.mapper;


import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.templates.BinTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BinTemplateToBinModel {

    BinTemplateToBinModel MAPPER = Mappers.getMapper(BinTemplateToBinModel.class);
    Bin binMapper (BinTemplate binTemplate);



}
