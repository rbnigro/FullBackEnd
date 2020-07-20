package br.com.linx.cardValidator.dto;

public class BinDTO {

    private Long bin;
    private String country;
    private String status;
    private String brand;
    private String description;

    public BinDTO(Long bin, String country, String status, String brand, String description) {
        super();
        this.bin = bin;
        this.country = country;
        this.status = status;
        this.brand = brand;
        this.description = description;
    }

    public Long getBin() {
        return bin;
    }

    public void setBin(Long bin) {
        this.bin = bin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
