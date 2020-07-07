package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepository extends JpaRepository<Bin, Integer> {

    Bin findByIdBin(Integer id_bin);

    Bin findByBin(Integer bin);

}
