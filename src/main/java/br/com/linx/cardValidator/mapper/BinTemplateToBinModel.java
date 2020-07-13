package br.com.linx.cardValidator.mapper;


import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.templates.BinTemplate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(nullValueCheckStrategy = ALWAYS)
public interface BinTemplateToBinModel {


    BinTemplateToBinModel MAPPER = Mappers.getMapper(BinTemplateToBinModel.class);
    Bin binMapper (BinTemplate binTemplate);


    void updateBinFromBinTemplate(BinTemplate template, @MappingTarget Bin binModel);



}
