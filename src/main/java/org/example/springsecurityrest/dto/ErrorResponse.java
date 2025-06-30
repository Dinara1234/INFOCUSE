package org.example.springsecurityrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private int code;

    private String message;

    @Builder.Default
    private String timestamp = Instant.now().toString();

    private String url;

}
