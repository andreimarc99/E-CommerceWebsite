package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.CustomerBuilder;
import ro.tuc.ds2020.dtos._builders.DeliveryGuyBuilder;
import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.customerDTOs.CustomerToBeInsertedDTO;
import ro.tuc.ds2020.dtos.deliveryGuyDTOs.DeliveryGuyDTO;
import ro.tuc.ds2020.dtos.deliveryGuyDTOs.DeliveryGuyToBeInsertedDTO;
import ro.tuc.ds2020.entities.Customer;
import ro.tuc.ds2020.entities.DeliveryGuy;
import ro.tuc.ds2020.repositories.CustomerRepository;
import ro.tuc.ds2020.repositories.DeliveryGuyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryGuyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final DeliveryGuyRepository deliveryGuyRepository;

    @Autowired
    public DeliveryGuyService(DeliveryGuyRepository deliveryGuyRepository) {
        this.deliveryGuyRepository = deliveryGuyRepository;
    }

    public List<DeliveryGuyDTO> findAll() {
        List<DeliveryGuy> deliveryGuys = deliveryGuyRepository.findAll();
        return deliveryGuys.stream()
                .map(DeliveryGuyBuilder::toDeliveryGuyDTO)
                .collect(Collectors.toList());
    }

    public Long insertDeliveryGuy(DeliveryGuyToBeInsertedDTO deliveryGuyToBeInsertedDTO) {
        DeliveryGuy deliveryGuy = DeliveryGuyBuilder.toDeliveryGuy(deliveryGuyToBeInsertedDTO);
        deliveryGuy = deliveryGuyRepository.save(deliveryGuy);
        LOGGER.debug("Delivery guy with username {} was inserted in db", deliveryGuyToBeInsertedDTO.getUsername());
        return deliveryGuy.getDeliveryGuyId();
    }

    public void deleteDeliveryGuy(Long deliveryGuyId) throws ResourceNotFoundException {
        Optional<DeliveryGuy> deliveryGuy = deliveryGuyRepository.findById(deliveryGuyId);
        if (!deliveryGuy.isPresent()) {
            throw new ResourceNotFoundException("Delivery guy with id " + deliveryGuyId + " not found.");
        }
        deliveryGuyRepository.deleteById(deliveryGuyId);
    }

    public DeliveryGuyDTO updateDeliveryGuy(DeliveryGuyToBeInsertedDTO deliveryGuyToBeInsertedDTO) throws ResourceNotFoundException {
        Optional<DeliveryGuy> deliveryGuy = deliveryGuyRepository.findById(deliveryGuyToBeInsertedDTO.getDeliveryGuyId());
        if (!deliveryGuy.isPresent()) {
            throw new ResourceNotFoundException("Delivery guy with username " + deliveryGuyToBeInsertedDTO.getUsername() + " not found.");
        }
        DeliveryGuy updatedDeliveryGuy = DeliveryGuyBuilder.toDeliveryGuy(deliveryGuyToBeInsertedDTO);
        DeliveryGuyDTO updatedDeliveryGuyDTO = DeliveryGuyBuilder.toDeliveryGuyDTO(deliveryGuyRepository.save(updatedDeliveryGuy));
        return updatedDeliveryGuyDTO;
    }
}
