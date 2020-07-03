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


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class BinBinType {

    @Column(name="binid_bin")
    private Long binIdBin;

    @Column(name="bin_typeid_type")
    private Long binTypeIdYype;
}
