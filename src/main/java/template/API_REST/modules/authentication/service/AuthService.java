package template.API_REST.modules.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import template.API_REST.config.GenericMapper.GenericMapper;
import template.API_REST.helpers.ApiResponse;
import template.API_REST.modules.authentication.helpers.jwt.JwtConfig;
import template.API_REST.modules.authentication.models.interfaces.AuthLoginRequest;
import template.API_REST.modules.authentication.models.interfaces.AuthRegisterRequest;
import template.API_REST.modules.user.models.User;
import template.API_REST.modules.user.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private GenericMapper genericMapper;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<ApiResponse<?>> register(AuthRegisterRequest authRegisterRequest) {

        User user = genericMapper.mapToEntity(authRegisterRequest, User.class);

        User newUser = userRepository.save(user);

        ApiResponse<User> response = new ApiResponse<>(
                "User successfully created",
                newUser,
                HttpStatus.OK
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<ApiResponse<?>> login(AuthLoginRequest authLoginRequest) {

        User userInDB = userRepository.findByEmail(authLoginRequest.getEmail());

        if (userInDB.getEmail() == null) {
            ApiResponse<String> response = new ApiResponse<>(
                    "Error: User not found",
                    null,
                    HttpStatus.BAD_REQUEST
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String token = jwtConfig.generateToken(userInDB.getUsername());

        ApiResponse<String> response = new ApiResponse<>(
                "login successful",
                token,
                HttpStatus.OK
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
