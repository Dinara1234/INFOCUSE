package org.example.springsecurityrest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"photographer", "photoStudio", "users"})
@Entity
public class PhotoSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photoStudio_id", nullable = true)
    private PhotoStudioEntity photoStudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photographer_id", nullable = true)
    private PhotographerDetails photographer;

    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Integer quantityOfModels;

    @ManyToMany
    @JoinTable(
            name = "users_photosessions",
            joinColumns = @JoinColumn(name = "photosession_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @Builder.Default
    private Set<UserEntity> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoSessionEntity photoSession = (PhotoSessionEntity) o;
        return id != null && id.equals(photoSession.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
