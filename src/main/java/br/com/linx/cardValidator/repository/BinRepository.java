package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BinRepository extends JpaRepository<Bin, Long> {

    Bin findByIdBin(Long id_bin);

    Bin findByBin(Long bin);

    @Modifying
    @Query("update Bin set status =:inativo where bin.idBin =:idBin")
    int markEntryAsRead(@Param("idBin") Long id_bin, @Param("inativo") String isRead);

}
