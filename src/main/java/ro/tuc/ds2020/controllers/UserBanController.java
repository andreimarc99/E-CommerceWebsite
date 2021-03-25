package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.userBanDTOs.UserBanDTO;
import ro.tuc.ds2020.services.UserBanService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user_bans")
public class UserBanController {
    private final UserBanService userBanService;

    @Autowired
    public UserBanController(UserBanService userBanService) {
        this.userBanService = userBanService;
    }

    @GetMapping()
    public ResponseEntity<List<UserBanDTO>> findAll() {
        List<UserBanDTO> userBanDTOS = userBanService.findUserBans();
        return new ResponseEntity<>(userBanDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertUserBan(@RequestBody UserBanDTO userBanDTO) {
        Long insertedUserBanId;
        try {
            insertedUserBanId = userBanService.insertUserBan(userBanDTO);
            return new ResponseEntity<>(insertedUserBanId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{userBanId}")
    public ResponseEntity<Long> deleteUserBan(@PathVariable Long userBanId) {
        try {
            userBanService.deleteUserBan(userBanId);
            return new ResponseEntity<>(userBanId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(userBanId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateUserBan(@RequestBody UserBanDTO userBanDTO) {
        try {
            userBanService.updateUserBan(userBanDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
