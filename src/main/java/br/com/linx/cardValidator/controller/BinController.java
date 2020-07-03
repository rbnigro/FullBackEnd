package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.services.BinServer;
import br.com.linx.cardValidator.templates.BinTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.DELETE;


@RestController("/bin")
@Api(value = "Realiza o crud do bin")
@Slf4j
public class BinController {

    @Autowired
    private BinServer binServer;


    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ApiOperation(value = "Cadastra o numero do bin")
    public ResponseEntity<?> registerBin(@RequestBody BinTemplate binTemplate) {
        binTemplate = this.binServer.saveBin(binTemplate);
        return  new ResponseEntity<BinTemplate>(binTemplate, HttpStatus.OK);
    }
//ajustes
    @DeleteMapping("bin/{id}")
    @ApiOperation(value = "Remove o numero do bin")
    public void delete(@PathVariable Integer id){
        binServer.deleteById(id);
    }


}
