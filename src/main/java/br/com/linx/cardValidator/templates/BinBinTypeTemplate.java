package br.com.linx.cardValidator.templates;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel

public class BinBinTypeTemplate {

    private Long binIdBin;
    private Long binTypeIdYype;

}
