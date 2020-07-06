package br.com.linx.cardValidator.templates;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel
public class BrandTemplate {

    private int idBrand;
    private String brand;
    private String description;
    private LocalDateTime createdAt;

}
