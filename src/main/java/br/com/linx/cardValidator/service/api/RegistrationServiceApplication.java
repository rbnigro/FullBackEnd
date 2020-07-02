package br.com.linx.cardValidator.service.api;
/*

import br.com.linx.cardValidator.repository.BinBinTypeRepository;
import br.com.linx.cardValidator.repository.BinRepository;
import br.com.linx.cardValidator.repository.BinTypeRepository;
import br.com.linx.cardValidator.repository.BrandRespository;

import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.model.BinBinType;
import br.com.linx.cardValidator.model.BinType;
import br.com.linx.cardValidator.model.Brand;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class RegistrationServiceApplication {

    // https://gradle.org/install/

    @Autowired
    private BinRepository binRepository;

    @Autowired
    private BinBinTypeRepository binBinTypeRepository;

    @Autowired
    private BinTypeRepository binTypeRepository;

    @Autowired
    private BrandRespository brandRespository;

    */
/* >>> BIN <<< *//*

    @PostMapping("/registerBin")
    public String registerBin(@RequestBody Bin bin) {
        binRepository.save(bin);
        return "Bin: [" + bin.getBin() + "] registrado com sucesso!";
    }

    @GetMapping("/getAllBin")
    public List<Bin> findAllBins() {
        return binRepository.findAll();
    }

    */
/* >>> Bin_Bin_Type <<< *//*

    @PostMapping("/registerBinBinType")
    public String registerBinBinType(@RequestBody BinBinType binBinType) {
        binBinTypeRepository.save(binBinType);
        return "BinBinType: [" + binBinType.getIdbin() + "/" + binBinType.getIdtype() + "] registrado com sucesso!";
    }

    @GetMapping("/getAllBinBinType")
    public List<BinBinType> findAllBinBinType() {
        return binBinTypeRepository.findAll();
    }

    */
/* >>> Bin_Type <<< *//*

    @PostMapping("/registerBinType")
    public String registerBinType(@RequestBody BinType binType) {
        binTypeRepository.save(binType);
        return "BinType: [" + binType.getIdType() + "/" + binType.getDescription() + "] registrado com sucesso!";
    }

    @GetMapping("/getAllBinType")
    public List<BinType> findAllBinType() {
        return binTypeRepository.findAll();
    }

    */
/* >>> Brand <<< *//*

    @PostMapping("/registerBrand")
    public String registerBrand(@RequestBody Brand brand) {
        brandRespository.save(brand);
        return "Brand: [" + brand.getId_brand() + "/" + brand.getDescription() + "] registrado com sucesso!";
    }

    @GetMapping("/getAllBrand")
    public List<Brand> findAllBrand() {
        return brandRespository.findAll();
    }
}
*/
