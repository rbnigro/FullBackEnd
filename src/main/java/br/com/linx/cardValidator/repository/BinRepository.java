package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.dto.BinDTO;
import br.com.linx.cardValidator.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BinRepository extends JpaRepository<Bin, Long> {

    Bin findByIdBin(final Long id_bin);

    /* Bim por Status - Inicio */
    @Query(value = "SELECT NEW br.com.linx.cardValidator.dto.BinDTO(b.idBin, b.bin, b.country, b.status, " +
            "b.brand.brand, b.brand.description) " +
            "from Bin AS b " +
            "where (b.bin = :bin) and (b.status = 'ativo')")
    BinDTO findByBin(@Param("bin") final Long bin);
    /* Bim por Status - Fim */

    @Modifying
    @Query("update Bin set status =:inativo where idBin =:idBin")
    int markEntryAsRead(@Param("idBin") Long id_bin, @Param("inativo") String isRead);

}
