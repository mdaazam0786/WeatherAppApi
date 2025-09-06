package com.example.Weather.API.exception;

import com.example.Weather.API.data.ErrorDto;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ErrorDto buildErrorDTO(String message, HttpStatus status) {
        return ErrorDto.builder().successStatus(false).httpStatus(status).message(message).build();
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorDto> appExceptionHandler(ApplicationException ex) {
        String message = ex.getMessage();
        HttpStatus httpStatus = ex.getStatus();
        ErrorDto errorDTO = buildErrorDTO(message, httpStatus);
        return new ResponseEntity<>(errorDTO, httpStatus);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDto> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        String message = "Required parameter '" + ex.getParameterName() + "' is missing.";
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorDto errorDTO = buildErrorDTO(message, statusCode);
        return new ResponseEntity<>(errorDTO, statusCode);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDto> handleNoResourceFoundException(
            NoResourceFoundException ex) {
        String message = ex.getMessage();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorDto errorDTO = buildErrorDTO(message, statusCode);
        return new ResponseEntity<>(errorDTO, statusCode);
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<ErrorDto> handleHttpClientErrorUnauthorizedException(
            HttpClientErrorException.Unauthorized ex) {
        String message = "Make sure you have configured a valid API_KEY.";
        HttpStatus statusCode = HttpStatus.UNAUTHORIZED;
        ErrorDto errorDTO = buildErrorDTO(message, statusCode);
        return new ResponseEntity<>(errorDTO, statusCode);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<ErrorDto> handleHttpClientErrorBadRequestException(
            HttpClientErrorException.BadRequest ex) {
        String message = ex.getMessage();
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorDto errorDTO = buildErrorDTO(message, statusCode);
        return new ResponseEntity<>(errorDTO, statusCode);
    }

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<ErrorDto> handleRequestNotPermittedException(
            RequestNotPermitted ex) {
        String message = ex.getMessage();
        HttpStatus statusCode = HttpStatus.TOO_MANY_REQUESTS;
        ErrorDto errorDTO = buildErrorDTO(message, statusCode);
        return new ResponseEntity<>(errorDTO, statusCode);
    }

    @ExceptionHandler(RedisConnectionFailureException.class)
    public ResponseEntity<ErrorDto> handleRedisConnectionFailureException(
            RedisConnectionFailureException ex) {
        String message = "Make sure REDIS server is up and running, then again make the request.";
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorDto errorDTO = buildErrorDTO(message, statusCode);
        return new ResponseEntity<>(errorDTO, statusCode);
    }
}
