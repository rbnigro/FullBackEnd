package br.com.linx.cardValidator.services;


import br.com.linx.cardValidator.mapper.BinModelToBinTemplate;
import br.com.linx.cardValidator.mapper.BinTemplateToBinModel;
import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.repository.BinRepository;
import br.com.linx.cardValidator.templates.BinTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@Slf4j
public class BinServer {

    @Autowired
    private BinRepository binRepository;


    public BinTemplate saveBin (BinTemplate binTemplate){

        log.info("[CARDVALIDATOR] -saving bin");
        Bin binModel =
        binRepository.save(BinTemplateToBinModel.MAPPER.binMapper(binTemplate));
        return BinModelToBinTemplate.MAPPER.binTemplateMapper(binModel);

    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Integer id) {

        binRepository.deleteById(id);

    }


}