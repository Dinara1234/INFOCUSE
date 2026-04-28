package org.example.springsecurityrest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsplashPhoto {
    private String id;
    private String slug;

    @JsonProperty("alternative_slugs")
    private Map<String, String> alternativeSlugs;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("promoted_at")
    private String promotedAt;

    private int width;
    private int height;
    private String color;

    @JsonProperty("blur_hash")
    private String blurHash;

    private String description;

    @JsonProperty("alt_description")
    private String altDescription;

    private List<Object> breadcrumbs; // может быть пустым массивом

    private UnsplashPhotoUrls urls;
    private UnsplashPhotoLinks links;

    private int likes;

    @JsonProperty("liked_by_user")
    private boolean likedByUser;

    private boolean bookmarked;

    @JsonProperty("current_user_collections")
    private List<Object> currentUserCollections; // или List<CollectionInfo>, если есть структура

    private Object sponsorship; // может быть null или объект

    @JsonProperty("topic_submissions")
    private Map<String, TopicSubmission> topicSubmissions;

    @JsonProperty("asset_type")
    private String assetType;

    private UnsplashUser user;
}
