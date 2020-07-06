package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BinRepository extends JpaRepository<Bin, Integer> {

    List<Bin> findByIdBin(Long id_bin);

    List<Bin> findByBin(Long bin);

}
