package org.example.springsecurityrest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@ToString(exclude = "photos")
@Table(name= "photostudio")
public class PhotoStudioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String title;


    @OneToMany(
            mappedBy = "photoStudio",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )

    @Builder.Default
    private Set<Photo> photos = new HashSet<>();

    @OneToMany(
            mappedBy = "photoStudio",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private Set<PhotoSessionEntity> photoSessions = new HashSet<>();

    public PhotoStudioEntity addPhoto(Photo photo) {
        photos.add(photo);
        photo.setPhotoStudio(this);
        return this;   }

    public void removePhoto(Photo photo) {
        photos.remove(photo);
        photo.setPhotoStudio(null);
    }
    public PhotoStudioEntity addPhotoSession(PhotoSessionEntity photoSession) {
        photoSessions.add(photoSession);
        photoSession.setPhotoStudio(this);
        return this;   }

    public void removePhotoSession(PhotoSessionEntity photoSession) {
        photoSessions.remove(photoSession);
        photoSession.setPhotoStudio(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoStudioEntity that = (PhotoStudioEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


}