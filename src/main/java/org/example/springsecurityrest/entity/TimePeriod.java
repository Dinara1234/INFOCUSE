package org.example.springsecurityrest.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimePeriod {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
