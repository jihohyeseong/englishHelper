package com.example.englishHelper.controller;

import com.example.englishHelper.dto.UserDto;
import com.example.englishHelper.entity.User;
import com.example.englishHelper.service.JoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService){

        this.joinService = joinService;
    }

    @PostMapping("/join")
    public ResponseEntity<UserDto> join(@RequestBody UserDto userDto){

        UserDto newUser = joinService.join(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
