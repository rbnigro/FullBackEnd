package br.com.linx.cardValidator.repository;


import br.com.linx.cardValidator.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandRespository extends JpaRepository<Brand, Long> {

    Brand findByIdBrand(Long id_brand);

    Brand findByBrand(Long brand);


}
