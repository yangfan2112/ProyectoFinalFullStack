package edu.cesur.fullstackProyecto.ExeptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ExeptionHandler extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(org.springframework.dao.DataIntegrityViolationException ex) {

        String exceptionMessage = ex.getMessage();
        Pattern pattern = Pattern.compile("^not-null (property references) a null or transient value : .+\\.([^\\s]+)$");
        Matcher matcher = pattern.matcher(exceptionMessage);

        String errorMessage = "Se ha producido un error en la base de datos";
        if (matcher.matches()) {
            String data = matcher.group(2);
            
            Map<String, String> values = new HashMap<>() {{
                put("nombre", " nombre");
                put("apellidos", " apellido");
                put("documentacion", " documento personal");
                put("email", " correo electrónico");
                put("tlf", " número de teléfono");
                put("fechanac", "a fecha de nacimiento");
                put("idioma", "idioma preferido");
                put("nacionalidad", "a nacionalidad"); 
            }};
            
            errorMessage = "No se ha introducido ningún" + values.get(data);
            
            
        } else if (exceptionMessage.contains("Ya existe la llave")) {
            Pattern llavePattern = Pattern.compile("Ya existe la llave \\(([^)]+)\\)=\\(([^)]+)\\)");
            Matcher llaveMatcher = llavePattern.matcher(exceptionMessage);

            if (llaveMatcher.find()) {
                String column = llaveMatcher.group(1);
                String data = llaveMatcher.group(2);
                
                Map<String, String> values = new HashMap<>() {{
                    put("documentacion", "el documento ");
                    put("email", "el correo ");
                    put("tlf", "el número de teléfono ");
                    put("documentacion, email", "el documento y el correo ");
                }};

                errorMessage = "Ya existe un usuario registrado con " + values.get(column) + data;
            }
        }

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerError(Exception ex) {
        String errorMessage = "Ocurrió un error interno en el servidor.";

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
