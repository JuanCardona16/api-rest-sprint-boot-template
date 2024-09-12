package template.API_REST.modules.authentication.models.interfaces;

import lombok.Data;

@Data
public class AuthLoginRequest {
    private String email;
    private String password;
}
