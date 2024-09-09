package template.API_REST.modules.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import template.API_REST.config.constants.Constants;

@RestController
@RequestMapping(Constants.AUTH)
public class authController {

    @GetMapping(value = Constants.LOGIN)
    public String login() {
        return "Ruta de inicio de secion del usuario";
    }

    @GetMapping(value = Constants.REGISTER)
    public String register() {
        return "Ruta de registro de nuevos usuarios";
    }

}
