package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.services.BinTypeServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BinTypeTemplate;
import br.com.linx.cardValidator.templates.BrandTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cardvalidator")
@Api(value = "Realiza o crud do binType")
@Slf4j
public class BinTypeController{

    @Autowired
    private BinTypeServer binTypeServer;

    @RequestMapping(value = "/binType/", method = RequestMethod.POST,
            produces = { "application/json", "application/xml" },
            consumes = {"application/json", "application/xml" })
    @ApiOperation(value = "Cadastra o binType")
    public ResponseEntity<?> registerBinType(@RequestBody BinTypeTemplate binTypeTemplate) {
        binTypeTemplate = this.binTypeServer.saveBinType(binTypeTemplate);
        return new ResponseEntity<BinTypeTemplate>(binTypeTemplate, HttpStatus.OK);
    }

    @RequestMapping(value = "/binType/bin/binTypes", method = RequestMethod.GET,
            produces = { "application/json" })
    @ApiOperation("Busca Todos os Bin Type´s")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<List<BinType>>(binTypeServer.findAll(),HttpStatus.OK);
    }


    //alteracao de dados - id_brand, bin, country, status
    @RequestMapping(value = "/binType/alter/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Altera um tipo específica")
    public ResponseEntity<?> alterType(@PathVariable("id") Long id,
                                        @RequestBody(required = true) BinTypeTemplate binTypeTemplateTemplate ) {
        binTypeTemplateTemplate = binTypeServer.mergeType(binTypeTemplateTemplate, id );
        if( binTypeTemplateTemplate != null){
            return new ResponseEntity<Object>(binTypeTemplateTemplate, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("{message: 'Update Don't OK' }", HttpStatus.NOT_FOUND);
    }


}
