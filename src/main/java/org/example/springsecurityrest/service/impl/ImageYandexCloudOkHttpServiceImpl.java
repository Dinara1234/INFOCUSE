package org.example.springsecurityrest.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.example.springsecurityrest.exception.ServiceException;
import org.example.springsecurityrest.exception.image.FailedToLoadImageServiceException;
import org.example.springsecurityrest.exception.image.IncorrectImageServiceException;
import org.example.springsecurityrest.exception.image.IncorrectImageSizeServiceException;
import org.example.springsecurityrest.exception.image.IncorrectMediaTypeServiceException;
import org.example.springsecurityrest.service.ImageService;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Slf4j
@Service
public class ImageYandexCloudOkHttpServiceImpl implements ImageService {

    private final S3Client s3Client;
    private final String bucketName;
    private final String endpointUrl;
    private final int maxSizeMB;

    public ImageYandexCloudOkHttpServiceImpl(
            @Value("${s3.accessKey}") String accessKey,
            @Value("${s3.secretKey}") String secretKey,
            @Value("${s3.bucket}") String bucketName,
            @Value("${s3.host}") String host,
            @Value("${s3.file.size.max}") int maxSizeMB
    ) throws URISyntaxException {

        this.bucketName = bucketName;
        this.endpointUrl = host;
        this.maxSizeMB = maxSizeMB;

        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        S3Configuration serviceConfiguration = S3Configuration.builder()
                .pathStyleAccessEnabled(true)
                .build();

        AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(credentials);

        this.s3Client = S3Client.builder()
                .endpointOverride(new URI(host))
                .credentialsProvider(credentialsProvider)
                .region(Region.US_EAST_1)
                .serviceConfiguration(serviceConfiguration)
                .build();
    }

    @Override
    public String save(MultipartFile image) {
        try {
            return this.uploadImage(image);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new IncorrectImageServiceException().setCause(e);
        }
    }

    public String uploadImage(MultipartFile multipartFile) throws IOException {
        this.validate(multipartFile);
        String key = this.generateUniqueFilename(multipartFile);

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(multipartFile.getContentType())
                .acl("public-read")
                .build();

        try (InputStream inputStream = multipartFile.getInputStream()) {
            PutObjectResponse response = s3Client.putObject(putObjectRequest,
                    RequestBody.fromInputStream(inputStream, multipartFile.getSize()));
            if (response.sdkHttpResponse().isSuccessful()) {
                return this.buildFileUrl(key);
            } else {
                throw new FailedToLoadImageServiceException(response.sdkHttpResponse().statusText().orElse(""));
            }
        }
    }

    private void validate(MultipartFile image) {
        if (image == null || image.getContentType() == null) {
            log.error("Image is null");
            throw new IncorrectImageServiceException();
        }
        if (image.getSize() / 1024 / 1024 > maxSizeMB) {
            log.error("Image size is too large");
            throw new IncorrectImageSizeServiceException();
        }
        if (!image.getContentType().startsWith("image/")) {
            log.error("Image media type is not supported");
            throw new IncorrectMediaTypeServiceException();
        }
    }

    private String generateUniqueFilename(MultipartFile image) {
        String filename = image.getOriginalFilename();
        return System.currentTimeMillis() + "_" + UUID.randomUUID() + filename.substring(filename.lastIndexOf('.'));
    }

    private String buildFileUrl(String key) {
        return String.format("%s/%s/%s", endpointUrl, bucketName, key);
    }
}
