package br.com.linx.cardValidator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

   @ManyToMany(cascade = {CascadeType.ALL})
   @JoinTable(name = "bin_bin_type",
   joinColumns = { @JoinColumn(name="binid_bin")},
   inverseJoinColumns = {@JoinColumn(name="bin_typeid_type")})
    private Set<BinType> binTypes;

    @Column(name="created_at")
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime updatedAt;

}