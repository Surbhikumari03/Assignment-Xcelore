package com.example.project.files;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "current_server_time",
        "response"
})
@SuperBuilder
public class ResponseModel {
    @JsonProperty("status")
    @JsonAlias("status_code")
    private HttpStatus status;

    @JsonProperty("current_server_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime currentServerTime;

    @JsonProperty("response")
    private Object response;

    private String messageCode;
}
