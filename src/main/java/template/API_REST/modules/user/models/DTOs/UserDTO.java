package template.API_REST.modules.user.models.DTOs;

import lombok.Data;

@Data
public class UserDTO {

    private Long uuid;
    private String username;
    private String email;
    private String password;

}
