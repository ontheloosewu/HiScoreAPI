package dev.wu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.LENGTH_REQUIRED, reason = "Initials cannot be empty")
public class EmptyInitialsException extends RuntimeException{
}
