package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.model.BinBinType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BinBinTypeRepository extends JpaRepository<BinBinType, Integer>  {

    List<BinBinType> findByIdBin(Long id_bin);

    List<BinBinType> findByIdType(Long id_type);
}
