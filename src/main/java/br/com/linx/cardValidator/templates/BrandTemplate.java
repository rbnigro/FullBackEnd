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
public class BrandTemplate {

        private Long idBrand; //ajuste
        private String brand;
        private String description;
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
        private LocalDateTime createdAt;

}
