package org.example.springsecurityrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PhotoSessionDto{

    private String title;
    private String address;
    private String photographerFirstName;
    private String photographerLastName;
    private String photographerEmail;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Integer quantityOfModels;
    private BigDecimal price;
    private String camera;

}
