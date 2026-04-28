package org.example.springsecurityrest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsplashUser {

    private String id;

    @JsonProperty("updated_at")
    private String updatedAt;

    private String username;
    private String name;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("twitter_username")
    private String twitterUsername;

    @JsonProperty("portfolio_url")
    private String portfolioUrl;

    private String bio;
    private String location;

    private UnsplashUserLinks links;

    @JsonProperty("profile_image")
    private UnsplashProfileImage profileImage;

    @JsonProperty("instagram_username")
    private String instagramUsername;

    @JsonProperty("total_collections")
    private int totalCollections;

    @JsonProperty("total_likes")
    private int totalLikes;

    @JsonProperty("total_photos")
    private int totalPhotos;

    @JsonProperty("total_free_photos")
    private int totalFreePhotos;

    @JsonProperty("total_promoted_photos")
    private int totalPromotedPhotos;

    @JsonProperty("total_illustrations")
    private int totalIllustrations;

    @JsonProperty("total_free_illustrations")
    private int totalFreeIllustrations;

    @JsonProperty("total_promoted_illustrations")
    private int totalPromotedIllustrations;

    @JsonProperty("accepted_tos")
    private boolean acceptedTos;

    @JsonProperty("for_hire")
    private boolean forHire;
}