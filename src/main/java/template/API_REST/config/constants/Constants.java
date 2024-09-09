package template.API_REST.config.constants;

public final class Constants {

    // Evitar que la clase sea instanciada
    private Constants() {
        throw new IllegalStateException("Clase de constantes");
    }

    // Constantes de rutas
    public static final String BASE_API = "/api";
    public static final String AUTH = BASE_API + "/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";

}
