package io.anviksha.dockerthreetierdemobackend.apis;

import io.anviksha.dockerthreetierdemobackend.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRecordNotFoundException(RecordNotFoundException exception) {
        return ResponseEntity
                .badRequest().body(Map.of("error", exception.getMessage()));
    }
}
