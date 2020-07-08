package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.repository.BinRepository;
import br.com.linx.cardValidator.services.BinServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bin")
@Api(value = "Realiza o crud do bin")
@Slf4j
public class BinController {

    @Autowired
    private BinServer binServer;

    @Autowired
    private BinRepository binRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "Cadastra o numero do bin")
    public ResponseEntity<?> registerBin(@RequestBody BinTemplate binTemplate) {
        binTemplate = this.binServer.saveBin(binTemplate);
        return new ResponseEntity<BinTemplate>(binTemplate, HttpStatus.OK);
    }

    @RequestMapping(value = "/bins/{id_bin}", method = RequestMethod.GET)
    @ApiOperation(value = "um bin especifico")
    public Bin findByIdBin(@PathVariable Long id_bin) {
        return binServer.findByIdBin(id_bin);
    }

    @RequestMapping(value = "/bins", method = RequestMethod.GET)
    @ApiOperation(value = "busca todos os numeros de bin")
    public List<Bin> findAll() {
        return binServer.findAll();
    }

    //exclusao logica
    @RequestMapping(value = "/{id}/{status}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Inativa um Bin específico")
    public ResponseEntity<?> markEntryAsRead( @PathVariable("id") Long id_bin, @PathVariable("status") String status ) {
        if( binServer.markEntryAsRead(id_bin,status)){
            return new ResponseEntity<Object>("{message: 'Update OK' }", HttpStatus.OK);
        }
        return new ResponseEntity<Object>("{message: 'Update Don't OK' }", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

