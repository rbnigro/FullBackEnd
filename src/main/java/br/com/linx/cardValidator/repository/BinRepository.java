package br.com.linx.cardValidator.repository;

import br.com.linx.cardValidator.model.Bin;
import br.com.linx.cardValidator.templates.BinTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BinRepository extends JpaRepository<Bin, Long> {

    Bin findByIdBin(Long id_bin);

    Bin findByIdBrand(Long id_brand);

    Bin findByBin(Long bin);

    @Modifying
    @Query("update Bin set status =:inativo where bin.idBin =:idBin")
    int markEntryAsRead(@Param("idBin") Long id_bin, @Param("inativo") String isRead);

    /*@Modifying
    @Query("update Bin set idBin=:idBin, id_Brand=:idBrand, bin=:bin, country=:country, status =:inativo where bin.idBin =:idBin")
    int markEntryAsReadF(@Param("idBin") Long id_bin,
                        @Param("idBrand") Long id_brand,
                        @Param("bin") Long bin,
                        @Param("country") String country,
                        @Param("inativo") String isRead);*/

}
