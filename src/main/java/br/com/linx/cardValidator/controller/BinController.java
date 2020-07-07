package br.com.linx.cardValidator.controller;

import br.com.linx.cardValidator.model.Bin;
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
        return new ResponseEntity<BinTemplate>(binTemplate, HttpStatus.OK);
    }

 //   @DeleteMapping("/{id}")
 //   @ApiOperation(value = "Remove o numero do bin")
 //   public void delete(@PathVariable Integer id){
 //       binServer.deleteById(id);
 //   }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca Bin específico")
    public Bin findByIdBin(@PathVariable Long id) {
        return binServer.findByIdBin(id);
   }

    @GetMapping(path = "/bins")
    @ApiOperation(value = "Busca todos os Bin's")
    public List<Bin> findAll() {
        return binServer.findAll();
    }

    /*
    * @PutMapping(value="/{id}")
public ResponseEntity update(@PathVariable("id") long id,
                                      @RequestBody Contact contact) {
   return repository.findById(id)
           .map(record -> {
               record.setName(contact.getName());
               record.setEmail(contact.getEmail());
               record.setPhone(contact.getPhone());
               Contact updated = repository.save(record);
               return ResponseEntity.ok().body(updated);
           }).orElse(ResponseEntity.notFound().build());
}*/
}
