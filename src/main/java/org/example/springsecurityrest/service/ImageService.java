package org.example.springsecurityrest.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String save(MultipartFile image);
}
