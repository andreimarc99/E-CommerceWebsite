package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.addressDTOs.AddressDTO;
import ro.tuc.ds2020.entities.Address;

public class AddressBuilder {

    public static Address toAddress(AddressDTO addressDTO) {
        return new Address(addressDTO.getAddressId(),
                addressDTO.getAlias(),
                addressDTO.getCountry(),
                addressDTO.getCounty(),
                addressDTO.getTown(),
                addressDTO.getStreetNr(),
                addressDTO.getCountryCode(),
                UserBuilder.toUser(addressDTO.getUser()));
    }

    public static AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(address.getAddressId(),
                address.getAlias(),
                address.getCountry(),
                address.getCounty(),
                address.getTown(),
                address.getStreetNr(),
                address.getCountryCode(),
                UserBuilder.toUserDTO(address.getUser()));
    }
}
