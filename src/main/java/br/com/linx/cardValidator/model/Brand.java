package br.com.linx.cardValidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name = "brand")
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_brand")
    private Long idBrand;

    @Column(length = 10)
    private String brand;

    @Column(length = 50)
    private String description;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
