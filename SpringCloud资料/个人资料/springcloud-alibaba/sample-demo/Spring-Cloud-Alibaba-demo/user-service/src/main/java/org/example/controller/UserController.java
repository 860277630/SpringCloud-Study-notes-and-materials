package org.example.controller;

import org.example.entity.User;
import org.example.utils.IdUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("test")
    public ResponseEntity<String> test() {
        User user = new User();
        String ids = IdUtils.getIds();
        return ResponseEntity.ok("Hello World");
    }
}
