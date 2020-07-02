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
public class BinTemplate {


    private Long idBin;
    private Long idBrand;
    private Long bin;
    private String country;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
