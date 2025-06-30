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
public class PhotoStudioDto {

    Long id;
    String address;
    String title;
    Set<Photo> photos;
}
