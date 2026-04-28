package org.example.springsecurityrest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsplashUserSocial {

    @JsonProperty("instagram_username")
    private String instagramUsername;

    @JsonProperty("portfolio_url")
    private String portfolioUrl;

    @JsonProperty("twitter_username")
    private String twitterUsername;

    @JsonProperty("paypal_email")
    private String paypalEmail;

}
