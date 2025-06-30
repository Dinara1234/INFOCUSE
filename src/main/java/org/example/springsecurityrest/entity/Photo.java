package org.example.springsecurityrest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"photographer", "photoStudio"})
@Accessors(chain = true)
@Builder
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photostudio_id", nullable = true)
    private PhotoStudioEntity photoStudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photographer_id", nullable = true)
    private PhotographerDetails photographer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id != null && id.equals(photo.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
