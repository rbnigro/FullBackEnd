package br.com.linx.cardValidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@ToString
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_brand")
    private Long idBrand;

    @Column(length = 10)
    private String brand;

    @Column(length = 50)
    private String description;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
