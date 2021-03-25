package ro.tuc.ds2020.dtos.addressDTOs;

import ro.tuc.ds2020.dtos.userDTOs.UserDTO;

public class AddressDTO {

    private Long addressId;
    private String alias;
    private String country;
    private String county;
    private String town;
    private String streetNr;
    private String countryCode;
    private UserDTO user;

    public AddressDTO() {}

    public AddressDTO(Long addressId, String alias, String country, String county, String town, String streetNr, String countryCode, UserDTO user) {
        this.addressId = addressId;
        this.alias = alias;
        this.country = country;
        this.county = county;
        this.streetNr = streetNr;
        this.town = town;
        this.countryCode = countryCode;
        this.user = user;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
