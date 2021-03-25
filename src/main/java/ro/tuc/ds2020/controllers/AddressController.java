package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.addressDTOs.AddressDTO;
import ro.tuc.ds2020.services.AddressService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    public ResponseEntity<List<AddressDTO>> findAll() {
        List<AddressDTO> addressDTOS = addressService.findAddresses();
        return new ResponseEntity<>(addressDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertAddress(@RequestBody AddressDTO addressDTO) {
        Long insertedAddressId;
        try {
            insertedAddressId = addressService.insertAddress(addressDTO);
            return new ResponseEntity<>(insertedAddressId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{addressId}")
    public ResponseEntity<Long> deleteAddress(@PathVariable Long addressId) {
        try {
            addressService.deleteAddress(addressId);
            return new ResponseEntity<>(addressId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(addressId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateAddress(@RequestBody AddressDTO addressDTO) {
        try {
            addressService.updateAddress(addressDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
