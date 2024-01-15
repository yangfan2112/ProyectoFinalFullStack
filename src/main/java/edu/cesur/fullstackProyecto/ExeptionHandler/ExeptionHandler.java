package edu.cesur.fullstackProyecto.ExeptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ExeptionHandler extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(org.springframework.dao.DataIntegrityViolationException ex) {

        String exceptionMessage = ex.getMessage();
        Pattern pattern = Pattern.compile("Ya existe la llave \\(([^)]+)\\)=\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(exceptionMessage);

        String errorMessage = "Ocurrió un error interno en el servidor.";
        if (matcher.find()) {
            String column = matcher.group(1);
            String data = matcher.group(2);
            
            switch (column){
            case "documentacion":
            	errorMessage = "Ya existe un usuario registrado con el documento " + data + ".";
            	break;
            case "email":
            	errorMessage = "Ya existe un usuario registrado con el correo " + data + ".";
            	break;
            default:
            	errorMessage = "Ya existe un usuario con estos valores";
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