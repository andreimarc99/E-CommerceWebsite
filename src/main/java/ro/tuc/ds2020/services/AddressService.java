package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.AddressBuilder;
import ro.tuc.ds2020.dtos._builders.AdminBuilder;
import ro.tuc.ds2020.dtos.addressDTOs.AddressDTO;
import ro.tuc.ds2020.dtos.adminDTOs.AdminDTO;
import ro.tuc.ds2020.dtos.adminDTOs.AdminToBeInsertedDTO;
import ro.tuc.ds2020.entities.Address;
import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDTO> findAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(AddressBuilder::toAddressDTO)
                .collect(Collectors.toList());
    }

    public Long insertAddress(AddressDTO addressDTO) {
        Address address = AddressBuilder.toAddress(addressDTO);
        address = addressRepository.save(address);
        LOGGER.debug("Address with ID {} was inserted in db", address.getAddressId());
        return address.getAddressId();
    }

    public void deleteAddress(Long addressId) throws ResourceNotFoundException {
        Optional<Address> address = addressRepository.findById(addressId);
        if (!address.isPresent()) {
            throw new ResourceNotFoundException("Address with id " + addressId + " not found.");
        }
        addressRepository.deleteById(addressId);
    }

    public AddressDTO updateAddress(AddressDTO addressDTO) throws ResourceNotFoundException {
        Optional<Address> address = addressRepository.findById(addressDTO.getAddressId());
        if (!address.isPresent()) {
            throw new ResourceNotFoundException("Address with ID " + addressDTO.getAddressId() + " not found.");
        }
        Address updatedAddress = AddressBuilder.toAddress(addressDTO);
        AddressDTO updatedAddressDTO = AddressBuilder.toAddressDTO(addressRepository.save(updatedAddress));
        return updatedAddressDTO;
    }
}
