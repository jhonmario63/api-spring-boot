package com.api.controllers;

import com.api.entities.dto.request.LoginRequest;
import com.api.entities.dto.response.ApiResponse;
import com.api.entities.entity.FuncionariosEntity;
import com.api.entities.entity.UsuariosEntity;
import com.api.security.AuthValidator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/v1/oauth")
public class AuthController {

    @Autowired
    private AuthValidator authValidator;

    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest object, HttpSession session) {
        ApiResponse response = authValidator.validate(object);

        session.setAttribute("user", "useer");
        return ResponseEntity.status(response.getStatus()).body(response);
    }


}
