package br.com.linx.cardValidator.dto;

public class BinDTO {

    private Long bin;
    private String country;
    private String status;

    public BinDTO(Long bin, String country, String status) {
        super();
        this.bin = bin;
        this.country = country;
        this.status = status;
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
}
