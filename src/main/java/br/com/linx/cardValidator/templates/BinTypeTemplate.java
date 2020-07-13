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
public class BinTypeTemplate {

    private Long idType;
    private String description;
    private LocalDateTime createdAt;
}
