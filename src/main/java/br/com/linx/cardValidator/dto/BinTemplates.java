package br.com.linx.cardValidator.dto;

import br.com.linx.cardValidator.templates.BinTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinTemplates {

    private List<BinTemplate> binTemplatesSuccess;
    private List<BinErrorDTO> binErrorDTOs;
}
