package com.example.englishHelper.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogoutController {

    private final RedisTemplate<String, String> redisTemplate;

    public LogoutController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/logout/{username}")
    public ResponseEntity<?> logout(@PathVariable String username) {
        redisTemplate.delete("refresh:" + username);
        return ResponseEntity.ok("Logged out successfully");
    }
}
