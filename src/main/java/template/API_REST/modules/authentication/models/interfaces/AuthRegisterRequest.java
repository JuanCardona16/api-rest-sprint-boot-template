package template.API_REST.modules.authentication.models.interfaces;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthRegisterRequest extends AuthLoginRequest {
    private String username;
}
