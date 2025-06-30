package org.example.springsecurityrest.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnsplashSearchResponse {
    private int total;
    private int total_pages;
    private List<UnsplashPhoto> results;
}
