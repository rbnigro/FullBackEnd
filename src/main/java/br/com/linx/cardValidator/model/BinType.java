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
public class BinType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_type")
    private Long idType;

    @Column(length = 50)
    private String description;

    @Column(name="created_at")
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "linkedBinTypes")
    private Set<Bin> binBinTypes;
}
