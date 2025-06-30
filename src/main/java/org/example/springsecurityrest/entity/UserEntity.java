package org.example.springsecurityrest.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@ToString(exclude = {"photographerDetails", "photoSessions"})
public class UserEntity implements Serializable {

    public enum State {
        OK, DELETED, BANNED
    }

    public enum Role {
        PHOTOGRAPHER,  USER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String hashPassword;

    @Enumerated(EnumType.STRING)
    private State state;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private PhotographerDetails photographerDetails;

    public void setPhotographerDetails(PhotographerDetails photographerDetails) {
        if (photographerDetails == null) {
            if (this.photographerDetails != null) {
                this.photographerDetails.setUser(null);
            }
        } else {
            photographerDetails.setUser(this);
        }
        this.photographerDetails = photographerDetails;
    }

    public void removePhotographerDetails() {
        if (this.photographerDetails != null) {
            this.photographerDetails.setUser(null);
            this.photographerDetails = null;
        }
    }

    @Builder.Default
    @ManyToMany(mappedBy = "users")
    private Set<PhotoSessionEntity> photoSessions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }






}
