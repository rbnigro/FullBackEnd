package br.com.linx.cardValidator.controller;


import br.com.linx.cardValidator.services.BinServer;
import br.com.linx.cardValidator.services.BinTypeServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/binType")
@Api(value = "Realiza o crud do binType")
@Slf4j
public class BinTypeController {

    @Autowired
    private BinTypeServer binTypeServer;

    @RequestMapping(value = "/binType",method = RequestMethod.POST)
    @ApiOperation(value = "Cadastra o binType")
    public ResponseEntity<?> registerBinType(@RequestBody BinTypeTemplate binTypeTemplate) {
        binTypeTemplate = this.binTypeServer.saveBinType(binTypeTemplate);
        return new ResponseEntity<BinTypeTemplate>(binTypeTemplate, HttpStatus.OK);
    }



}
