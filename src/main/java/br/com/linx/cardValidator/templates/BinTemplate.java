package br.com.linx.cardValidator.templates;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.*;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BinTemplate {

    private Long idBin;
    @NotNull
    @NotEmpty
    private Long idBrand;
    @NotNull
    @NotEmpty
    private Long bin;
    private String country;
    private String status;
    @NotNull
    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime updatedAt;

}
