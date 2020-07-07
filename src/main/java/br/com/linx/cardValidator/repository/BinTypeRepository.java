package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.model.BinType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BinTypeRepository extends JpaRepository<BinType, Integer> {

    List<BinType> findByIdType(Long id_type);

}
