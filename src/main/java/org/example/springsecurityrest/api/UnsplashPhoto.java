package org.example.springsecurityrest.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnsplashPhoto {
    private String id;
    private String slug;
    private String created_at;
    private int width;
    private int height;
    private String color;
    private String blur_hash;
    private String description;
    private String alt_description;
    private UnsplashPhotoUrls urls;
    private UnsplashUser user;
}
