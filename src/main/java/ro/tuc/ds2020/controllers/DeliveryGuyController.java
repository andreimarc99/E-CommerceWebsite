package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.deliveryGuyDTOs.DeliveryGuyDTO;
import ro.tuc.ds2020.dtos.deliveryGuyDTOs.DeliveryGuyToBeInsertedDTO;
import ro.tuc.ds2020.services.DeliveryGuyService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/delivery_guys")
public class DeliveryGuyController {
    private final DeliveryGuyService deliveryGuyService;

    @Autowired
    public DeliveryGuyController(DeliveryGuyService deliveryGuyService) {
        this.deliveryGuyService = deliveryGuyService;
    }

    @GetMapping()
    public ResponseEntity<List<DeliveryGuyDTO>> findAll() {
        List<DeliveryGuyDTO> deliveryGuyDTOS = deliveryGuyService.findAll();
        return new ResponseEntity<>(deliveryGuyDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertDeliveryGuy(@RequestBody DeliveryGuyToBeInsertedDTO deliveryGuyToBeInsertedDTO) {
        Long insertedDeliveryGuyId;
        try {
            insertedDeliveryGuyId = deliveryGuyService.insertDeliveryGuy(deliveryGuyToBeInsertedDTO);
            return new ResponseEntity<>(insertedDeliveryGuyId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/{deliveryGuyId}")
    public ResponseEntity<Long> deleteDeliveryGuy(@PathVariable Long deliveryGuyId) {
        try {
            deliveryGuyService.deleteDeliveryGuy(deliveryGuyId);
            return new ResponseEntity<>(deliveryGuyId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(deliveryGuyId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateDeliveryGuy(@RequestBody DeliveryGuyToBeInsertedDTO deliveryGuyToBeInsertedDTO) {
        try {
            deliveryGuyService.updateDeliveryGuy(deliveryGuyToBeInsertedDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
