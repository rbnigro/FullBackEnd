package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepository extends JpaRepository<Bin, Long> {

    Bin findByIdBin(Long id_bin);

    Bin findByIdBrand(Long id_brand);

    Bin findByBin(Long bin);

}
