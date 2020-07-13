package br.com.linx.cardValidator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_bin")
    private Long idBin;

    @Column(name="id_brand")
    private Long idBrand;

    @Column(unique = true)
    private Long bin;

    @Column(length = 10)
    private String country;

    @Column(length = 10)
    private String status;

    @Column(name="created_at")
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime updatedAt;

}