package com.api.security;

import com.api.entities.dto.request.LoginRequest;
import com.api.entities.dto.response.ApiResponse;
import com.api.entities.entity.UsuariosEntity;
import com.api.services.interfaces.UsuariosInterfaces;
import com.api.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator {

    @Autowired
    private UsuariosInterfaces usuariosInterfaces;

    public ApiResponse validate(LoginRequest object) {
        UsuariosEntity user = null;
        try {
            if (object.getUserName() == null || object.getPassword() == null || object.getUserName().isEmpty() || object.getPassword().isEmpty()) {
                return new ApiResponse(null, "username or password is not invalid", HttpStatus.OK.value());
            }
            user = usuariosInterfaces.login(object.getUserName(), Util.encript(object.getPassword()));
            if (user == null) {
                return new ApiResponse(null, HttpStatus.UNAUTHORIZED.getReasonPhrase(), HttpStatus.UNAUTHORIZED.value());
            }
        } catch (Exception ex) {
            return new ApiResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ApiResponse(user, "Login successful", HttpStatus.OK.value());
    }

}
