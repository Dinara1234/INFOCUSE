package org.example.springsecurityrest.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@ToString(exclude = "user")
@Entity
@Table(name="photographer_details")
public class PhotographerDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false,
            unique = true
    )
    private UserEntity user;

    @OneToMany(
            mappedBy = "photographer" ,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private Set<Photo> photos = new HashSet<>();

    @OneToMany(
            mappedBy = "photographer" ,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private Set<PhotoSessionEntity> photoSessions = new HashSet<>();


    public void addPhoto(Photo photo) {
        photos.add(photo);
        photo.setPhotographer(this);
    }

    public void removePhoto(Photo photo) {
        photos.remove(photo);
        photo.setPhotographer(null);
    }
    public void addPhotoSession(PhotoSessionEntity photoSession) {
        photoSessions.add(photoSession);
        photoSession.setPhotographer(this);
    }

    public void removePhotoSession(PhotoSessionEntity photoSession) {
        photoSessions.remove(photoSession);
        photoSession.setPhotographer(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotographerDetails that = (PhotographerDetails) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


}
