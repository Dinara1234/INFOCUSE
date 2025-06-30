package org.example.springsecurityrest.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class UnsplashService {

    private final RestTemplate restTemplate;

    @Value("${unsplash.api.access-key}")
    private String accessKey;

    @Value("${unsplash.api.base-url}")
    private String baseUrl;

    public UnsplashService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public UnsplashSearchResponse searchPhotos(String query, int page, int perPage) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/search/photos")
                .queryParam("query", query)
                .queryParam("page", page)
                .queryParam("per_page", perPage)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<UnsplashSearchResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    UnsplashSearchResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                System.err.println("Unsplash API Error: " + response.getStatusCode());
                return null;
            }
        } catch (HttpClientErrorException e) {
            System.err.println("Client Error calling Unsplash API: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return null;
        } catch (Exception e) {
            System.err.println("Error calling Unsplash API: " + e.getMessage());
            return null;
        }
    }

    public List<UnsplashPhoto> getRandomPhotos(String query) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/photos/random")
                .queryParam("count", 1);

        if (query != null && !query.isEmpty()) {
            uriBuilder.queryParam("query", query);
        }

        String url = uriBuilder.toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {

            ResponseEntity<UnsplashPhoto[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    UnsplashPhoto[].class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return List.of(response.getBody());
            } else {
                System.err.println("Unsplash API Error for random photo: " + response.getStatusCode());
                return Collections.emptyList();
            }
        } catch (HttpClientErrorException e) {
            System.err.println("Client Error calling Unsplash API for random photo: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return Collections.emptyList();
        } catch (Exception e) {
            System.err.println("Error calling Unsplash API for random photo: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
