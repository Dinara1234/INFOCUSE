package org.example.springsecurityrest.dto;

import lombok.*;
import org.example.springsecurityrest.entity.Photo;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhotographerDto {

    Long id;
    String firstName;
    String lastName;
    String title;
    String email;
    Set<Photo> photos;
}