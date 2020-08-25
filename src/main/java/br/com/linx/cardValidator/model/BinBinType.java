package br.com.linx.cardValidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name = "bin_bin_type")
@IdClass(BinBinType.class)
public class BinBinType implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "binid_bin")
    private Bin bin;

    @Id
    @ManyToOne
    @JoinColumn(name = "bin_typeid_type")
    private BinType binType;
}
