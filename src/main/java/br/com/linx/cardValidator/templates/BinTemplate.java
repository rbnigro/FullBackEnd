package br.com.linx.cardValidator.templates;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(timezone = "UTC")
    private LocalDateTime createdAt;
    @JsonFormat(timezone = "UTC")
    private LocalDateTime updatedAt;

}
