package br.com.linx.cardValidator.dto;

public class BinDTO {

    private Long idBin;
    private Long bin;
    private String country;
    private String status;
    private String brand;
    private String description;
    private String descType;
    private Boolean paymentTypeIsValid;

    public BinDTO(Long idBin, Long bin, String country, String status, String brand, String description, String descType) {
        super();
        this.idBin = idBin;
        this.bin = bin;
        this.country = country;
        this.status = status;
        this.brand = brand;
        this.description = description;
        this.descType = descType;
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

    public Long getIdBin() {
        return idBin;
    }

    public void setIdBin(Long idBin) {
        this.idBin = idBin;
    }

    public String getDescType() {
        return descType;
    }

    public void setDescType(String descType) {
        this.descType = descType;
    }

    public Boolean getPaymentTypeIsValid() {
        return paymentTypeIsValid;
    }

    public void setPaymentTypeIsValid(Boolean paymentTypeIsValid) {
        this.paymentTypeIsValid = paymentTypeIsValid;
    }
}
