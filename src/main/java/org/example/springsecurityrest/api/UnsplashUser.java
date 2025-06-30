package org.example.springsecurityrest.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnsplashUser {
    private String id;
    private String username;
    private String name;
    private String first_name;
    private String last_name;
    private String portfolio_url;
}