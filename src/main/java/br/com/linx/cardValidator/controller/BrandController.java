package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.services.BrandServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import br.com.linx.cardValidator.templates.BrandTemplate;
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


@RestController("/brand")
@Api(value = "Realiza o crud do brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandServer brandServer;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ApiOperation(value = "Cadastra o numero do brand")
    public ResponseEntity<?> registerBrand(@RequestBody BrandTemplate brandTemplate) {
        brandTemplate = this.brandServer.saveBrand(brandTemplate);
        return new ResponseEntity<BrandTemplate>(brandTemplate, HttpStatus.OK);
    }

}
