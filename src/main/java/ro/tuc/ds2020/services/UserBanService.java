package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.UserBanBuilder;
import ro.tuc.ds2020.dtos.userBanDTOs.UserBanDTO;
import ro.tuc.ds2020.entities.UserBan;
import ro.tuc.ds2020.repositories.UserBanRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserBanService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBanService.class);
    private final UserBanRepository userBanRepository;

    @Autowired
    public UserBanService(UserBanRepository userBanRepository) {
        this.userBanRepository = userBanRepository;
    }

    public List<UserBanDTO> findUserBans() {
        List<UserBan> userBans = userBanRepository.findAll();
        return userBans.stream()
                .map(UserBanBuilder::toUserBanDTO)
                .collect(Collectors.toList());
    }

    public Long insertUserBan(UserBanDTO userBanDTO) {
        UserBan userBan = UserBanBuilder.toUserBan(userBanDTO);
        userBan = userBanRepository.save(userBan);
        LOGGER.debug("UserBan with ID {} was inserted in db", userBanDTO.getBanId());
        return userBan.getBanId();
    }

    public void deleteUserBan(Long userBanId) throws ResourceNotFoundException {
        Optional<UserBan> userBan = userBanRepository.findById(userBanId);
        if (!userBan.isPresent()) {
            throw new ResourceNotFoundException("UserBan with id " + userBanId + " not found.");
        }
        userBanRepository.deleteById(userBanId);
    }

    public UserBanDTO updateUserBan(UserBanDTO userBanDTO) throws ResourceNotFoundException {
        Optional<UserBan> userBan = userBanRepository.findById(userBanDTO.getBanId());
        if (!userBan.isPresent()) {
            throw new ResourceNotFoundException("UserBan with ID " + userBanDTO.getBanId() + " not found.");
        }
        UserBan updatedUserBan = UserBanBuilder.toUserBan(userBanDTO);
        UserBanDTO updatedUserBanDTO = UserBanBuilder.toUserBanDTO(userBanRepository.save(updatedUserBan));
        return updatedUserBanDTO;
    }
}
