package com.example.englishHelper.controller;

import com.example.englishHelper.dto.UserDto;
import com.example.englishHelper.entity.User;
import com.example.englishHelper.service.JoinService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService){

        this.joinService = joinService;
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsMap);
        }

        if(joinService.alreadyExistUsername(userDto.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        UserDto newUser = joinService.join(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
