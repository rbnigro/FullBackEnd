package br.com.linx.cardValidator.dto;

import br.com.linx.cardValidator.templates.BinTemplate;

public class BinErrorDTO {

    private String description;

    private String elements;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public BinErrorDTO(String notFound, BinTemplate binTemplateMapper) {

    }

}
