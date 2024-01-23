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
        Pattern notnullPattern = Pattern.compile("^not-null (property references) a null or transient value : .+\\.([^\\s]+)$");
        Matcher notnullMatcher = notnullPattern.matcher(exceptionMessage);

        String errorMessage = "Se ha producido un error en la base de datos";
        if (notnullMatcher.matches()) {
            String data = notnullMatcher.group(2);
            
            Map<String, String> values = new HashMap<>() {{
                put("nombre", " nombre");
                put("apellidos", " apellido");
                put("documentacion", " documento personal");
                put("email", " correo electrónico");
                put("tlf", " número de teléfono");
                put("fechanac", "a fecha de nacimiento");
                put("idioma", "idioma preferido");
                put("nacionalidad", "a nacionalidad");
                put("empresa", "a empresa");
                put("ubicacion", "a ubicación");
                put("fechaini", "a fecha de inicio");
                put("pais", " pais ");
                put("servicios", "servicio");
            }};
            
            errorMessage = "No se ha introducido ningún" + values.get(data);
            
            
        } else if (exceptionMessage.contains("Ya existe la llave")) {
            Pattern llavePattern = Pattern.compile("Ya existe la llave \\(([^)]+)\\)=\\(([^)]+)\\)");
            Matcher llaveMatcher = llavePattern.matcher(exceptionMessage);
            
            Pattern insertPattern = Pattern.compile("insert into\\s+(\\w+)");
            Matcher insertMatcher = insertPattern.matcher(exceptionMessage);

            if (llaveMatcher.find() && insertMatcher.find()) {
                String columna = llaveMatcher.group(1);
                String valor = llaveMatcher.group(2);
                String tabla = insertMatcher.group(1);
                
                Map<String, String> values = new HashMap<>() {{
                    put("documentacion", "el documento ");
                    put("email", "el correo ");
                    put("tlf", "el número de teléfono ");
                }};

                errorMessage = "Ya existe un " + tabla.substring(0, tabla.length() - 1) + " registrado con " + values.get(columna) + valor;
            } else {
            	errorMessage = "ERROR";
            }
        }

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerError(Exception ex) {
        String errorMessage = "Ocurrió un error interno en el servidor."+ ex;

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
