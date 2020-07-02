package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.services.BinServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController("/bin")
@Api(value = "Realiza o crud do bin")
@Slf4j
public class BinController {

    @Autowired
    private BinServer binServer;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<?> registerBin(@RequestBody BinTemplate binTemplate) {
        binTemplate = this.binServer.saveBin(binTemplate);
        return  new ResponseEntity<BinTemplate>(binTemplate, HttpStatus.OK);
    }
}
