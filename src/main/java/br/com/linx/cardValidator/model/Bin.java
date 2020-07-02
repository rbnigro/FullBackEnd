package br.com.linx.cardValidator.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bin")
    private Long idBin;

    @Column(name="id_brand")
    private Long idBrand;

    private Long bin;

    private String country;

    private LocalDateTime createdAt;

}
