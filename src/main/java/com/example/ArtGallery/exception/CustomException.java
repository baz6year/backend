package com.example.ArtGallery.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter
@Getter
public class CustomException extends RuntimeException {
    private HttpStatus status;

    public CustomException(String message, HttpStatus status) {
      super(message);
      this.status = status;
    }

    @Override
    public String toString() {
      return "Message: " + getMessage() + "Status: " + getStatus();
    }
  }



