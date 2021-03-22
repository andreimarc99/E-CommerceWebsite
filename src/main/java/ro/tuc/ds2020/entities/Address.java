package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId", nullable = false)
    private Long addressId;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "county", nullable = false)
    private String county;

    @Column(name = "town", nullable = false)
    private String town;

    @Column(name = "countryCode", nullable = false)
    private String countryCode;

    @ManyToOne()
    @JoinColumn(name = "username")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
