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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BinServer {

    @Autowired
    private BinRepository binRepository;

    public BinTemplate saveBin (BinTemplate binTemplate){

        log.info("[CARDVALIDATOR] -saving bin");
        Bin binModel = binRepository.save(BinTemplateToBinModel.MAPPER.binMapper(binTemplate));
        return BinModelToBinTemplate.MAPPER.binTemplateMapper(binModel);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        binRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Bin findByIdBin(Long id_bin) {
        Bin bin = binRepository.findByIdBin(id_bin);
        return bin;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Bin findByIdBrand(Long id_brand) {
        Bin bin = binRepository.findByIdBrand(id_brand);
        return bin;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Bin findByBin(Long numeroBin) {
        Bin bin = binRepository.findByBin(numeroBin);
        return bin;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Bin> findAll() {
        List<Bin> bins = new ArrayList<>();
        binRepository.findAll().forEach(bins::add);
        return bins;
    }

    @Transactional
    public boolean markEntryAsRead (Long idBin, String status){
         int return_ = binRepository.markEntryAsRead(idBin, status);
         log.info("UPDATE REALIZADO " + return_);
         return return_==1;
    }

}
