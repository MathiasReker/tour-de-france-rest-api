package com.example.eksamen.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder({"success", "message", "errors"})
public class ApiError {

  @JsonProperty("success")
  private boolean success = false;

  @JsonProperty("message")
  private String message;

  @JsonProperty("errors")
  private String error;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  public ApiError(LocalDateTime timeStamp, String message, String error) {
    this.timestamp = timeStamp;
    this.message = message;
    this.error = error;
  }
}
