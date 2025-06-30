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
public class PhotographerDetailsDto {
    private String title;
    private Set<Photo> photos;



}
