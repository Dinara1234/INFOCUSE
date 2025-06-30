package org.example.springsecurityrest.api;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnsplashPhotoUrls {
    private String raw;
    private String full;
    private String regular;
    private String small;
    private String thumb;
    private String small_s3;
}
