package org.example.springsecurityrest.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private String firstName;

    private String lastName;

    private String email;
}
