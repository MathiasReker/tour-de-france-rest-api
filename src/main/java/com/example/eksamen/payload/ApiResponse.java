package com.example.eksamen.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success", "message"})
public class ApiResponse {

  @JsonProperty("success")
  private boolean success;

  @JsonProperty("message")
  private String message;

  private Page<?> data;

  private Object content;

  public ApiResponse(Boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public ApiResponse(Boolean success, String message, Object content) {
    this.success = success;
    this.message = message;
    this.content = content;
  }

  public ApiResponse(Boolean success, String message, Page<?> data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }
}
