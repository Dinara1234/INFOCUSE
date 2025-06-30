package org.example.springsecurityrest.repository;

import org.example.springsecurityrest.entity.Photo;
import org.example.springsecurityrest.entity.PhotoStudioEntity;
import org.example.springsecurityrest.entity.PhotographerDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
    Set<Photo> findByPhotoStudio(PhotoStudioEntity photoStudio);
    Set<Photo> findByPhotographer(PhotographerDetails photographerDetails);
}
