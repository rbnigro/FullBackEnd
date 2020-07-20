package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.repository.BinRepository;
import br.com.linx.cardValidator.services.BinServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cardvalidator")
@Api(value = "Realiza o crud do bin")
@Slf4j
public class BinController<binTemplate> {

    @Autowired
    private BinServer binServer;

    @Autowired
    private BinRepository binRepository;

    // Inclusao unitaria
    @RequestMapping(value = "/bin/", method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ApiOperation(value = "Cadastra o numero do bin")
    public ResponseEntity<?> registerBin(@RequestBody BinTemplate binTemplate) {
        binTemplate = this.binServer.saveBin(binTemplate);
        return new ResponseEntity<BinTemplate>(binTemplate, HttpStatus.OK);
    }

    // Inclusão massiva
    @RequestMapping(value="/bin/all", method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ApiOperation(value = "Cadastra o numero do bin (em lote)")
    public ResponseEntity<?> registerAllBin(@RequestBody(required = true) List<BinTemplate> binTemplate) {
        binTemplate = this.binServer.saveBin(binTemplate);
        return new ResponseEntity<List<BinTemplate>>(binTemplate, HttpStatus.OK);
    }

    // Busca um idBin especifico
    @RequestMapping(value = "/bin/idbin/{idBin}", method = RequestMethod.GET,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ApiOperation(value = "Busca um idBin especifico")
    public Bin findByIdBin(@PathVariable("idBin") Long idBin) {
        return binServer.findByIdBin(idBin);
    }

    // Busca um Bin específico
    // @RequestMapping(value = "/bin/bin/{bin}/{status}",
    @RequestMapping(value = "/bin/bin/{bin}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ApiOperation(value = "Busca um Bin especifico")
    public ResponseEntity<?> findByBin(
            @PathVariable("bin") Long bin) {
        return new ResponseEntity<>(binServer.findByBin(bin), HttpStatus.OK);
    }

    // lista todos os bins paginado
    @RequestMapping(value = "/bin/bins", method = RequestMethod.GET,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ApiOperation(value = "Busca todos os numeros de bin")
    public List<Bin> findAll(Pageable pageable) {
        return binServer.findAll(pageable); // default = 20
        // http://localhost:8080/cardvalidator/bin/bins?page=0&size=5
        // http://localhost:8080/cardvalidator/bin/bins?page=1
    }

    //alteracao de dados - id_brand, bin, country, status
    @RequestMapping(value = "/bin/alter/{id}", method = RequestMethod.PATCH,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ApiOperation(value = "Altera um Bin específico")
    public ResponseEntity<?> markEntryAsReadAlter(@PathVariable("id") Long id,
                                              @RequestBody(required = true) BinTemplate binTemplate ) {
        binTemplate = binServer.mergeBin(binTemplate, id );
        if( binTemplate != null){
            return new ResponseEntity<Object>(binTemplate, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("{message: 'Update Don't OK' }", HttpStatus.NOT_FOUND);
    }

    //exclusao logica -
    @RequestMapping(value = "/bin/{id}/{status}", method = RequestMethod.PATCH,
            produces = { "application/json", "application/xml" },
            consumes = {"application/json", "application/xml" })
    @ApiOperation(value = "Inativa um Bin específico")
    public ResponseEntity<?> markEntryAsRead( @PathVariable("id") Long id_bin, @PathVariable("status") String status ) {
        if( binServer.markEntryAsRead(id_bin,status)){
            return new ResponseEntity<Object>("{message: 'Update OK' }", HttpStatus.OK);
        }
        return new ResponseEntity<Object>("{message: 'Update Don't OK' }", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

