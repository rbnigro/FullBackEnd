package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.model.Brand;
import br.com.linx.cardValidator.services.BrandServer;
import br.com.linx.cardValidator.templates.BinTemplate;
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
@Api(value = "Realiza o crud do brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandServer brandServer;

    @RequestMapping(value = "/brand/", method = RequestMethod.POST,
            produces = { "application/json" },
            consumes = {"application/json" })
    @ApiOperation(value = "Cadastra o numero do brand")
    public ResponseEntity<?> registerBrand(@RequestBody BrandTemplate brandTemplate) {
        brandTemplate = this.brandServer.saveBrand(brandTemplate);
        return new ResponseEntity<BrandTemplate>(brandTemplate, HttpStatus.OK);
    }

    @RequestMapping(value = "/brand/brands", method = RequestMethod.GET,
            produces = {"application/json" })

    @ApiOperation(value = "Busca Todos os Brand´s")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<List<Brand>>(brandServer.findAll(), HttpStatus.OK);
    }

    //alteracao de dados - id_brand, bin, country, status
    @RequestMapping(value = "/brand/alter/{id}", method = RequestMethod.PATCH,
            produces = { "application/json" },
            consumes = {"application/json" })
    @ApiOperation(value = "Altera uma brand específica")
    public ResponseEntity<?> alterBrand(@PathVariable("id") Long id,
                                              @RequestBody(required = true) BrandTemplate brandTemplate ) {
        brandTemplate = brandServer.mergeBrand(brandTemplate, id );
        if( brandTemplate != null){
            return new ResponseEntity<Object>(brandTemplate, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("{message: 'Update Don't OK' }", HttpStatus.NOT_FOUND);
    }

}
