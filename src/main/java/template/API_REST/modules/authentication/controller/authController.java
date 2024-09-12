package template.API_REST.modules.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import template.API_REST.config.constants.Constants;
import template.API_REST.helpers.ApiResponse;
import template.API_REST.modules.authentication.models.interfaces.AuthLoginRequest;
import template.API_REST.modules.authentication.models.interfaces.AuthRegisterRequest;
import template.API_REST.modules.authentication.service.AuthService;

@RestController
@RequestMapping(Constants.AUTH)
public class authController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = Constants.LOGIN)
    public ResponseEntity<ApiResponse<?>> login(@RequestBody AuthLoginRequest authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping(value = Constants.REGISTER)
    public ResponseEntity<ApiResponse<?>> register(@RequestBody AuthRegisterRequest authRegisterRequest) {
        return authService.register(authRegisterRequest);
    }

}
