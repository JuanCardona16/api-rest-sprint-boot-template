package template.API_REST.config.RouteNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerRouteNotFound {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> routeNotFound(NoHandlerFoundException exception) {
        String message = "Ruta solicitada no existe. Verifique el endpoint";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}
