package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.deliveryGuyDTOs.DeliveryGuyDTO;
import ro.tuc.ds2020.dtos.deliveryGuyDTOs.DeliveryGuyToBeInsertedDTO;
import ro.tuc.ds2020.entities.DeliveryGuy;
import ro.tuc.ds2020.entities.User;

public class DeliveryGuyBuilder {

    public static DeliveryGuy toDeliveryGuy(DeliveryGuyDTO deliveryGuyDTO) {
        return new DeliveryGuy(deliveryGuyDTO.getDeliveryGuyId(),
                UserBuilder.toUser(deliveryGuyDTO.getUser()),
                deliveryGuyDTO.getSalary(),
                deliveryGuyDTO.getDateHired());
    }

    public static DeliveryGuyDTO toDeliveryGuyDTO(DeliveryGuy deliveryGuy) {
        return new DeliveryGuyDTO(deliveryGuy.getDeliveryGuyId(),
                UserBuilder.toUserDTO(deliveryGuy.getUser()),
                deliveryGuy.getSalary(),
                deliveryGuy.getDateHired());
    }

    public static DeliveryGuy toDeliveryGuy(DeliveryGuyToBeInsertedDTO deliveryGuyToBeInsertedDTO) {
        return new DeliveryGuy(deliveryGuyToBeInsertedDTO.getDeliveryGuyId(),
                new User(deliveryGuyToBeInsertedDTO.getUsername(),
                        deliveryGuyToBeInsertedDTO.getPassword(),
                        deliveryGuyToBeInsertedDTO.getRole(),
                        deliveryGuyToBeInsertedDTO.getCNP(),
                        deliveryGuyToBeInsertedDTO.getBirthDate(),
                        deliveryGuyToBeInsertedDTO.getFirstName(),
                        deliveryGuyToBeInsertedDTO.getLastName(),
                        deliveryGuyToBeInsertedDTO.getGender()),
                deliveryGuyToBeInsertedDTO.getSalary(),
                deliveryGuyToBeInsertedDTO.getDateHired());
    }
}
