package org.example.springsecurityrest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.dto.ValidationErrorResponse;
import org.example.springsecurityrest.dto.request.CreatePhotoSessionRequest;
import org.example.springsecurityrest.service.PhotoSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "PhotoSession Api", description = "API ajax запросов для записи на фотосессии")
public class PhotoSessionRestController {

    private final PhotoSessionService photoSessionService;

    @Operation(summary = "Отправить данные для создания фотосессии",
            description = "POST-запрос для создания фотосессии.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request на создание фотосессии",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreatePhotoSessionRequest.class)
                    )
            )
    )
    @PostMapping("/new-photosession")
    public ResponseEntity<?> createPhotoSession(@RequestBody CreatePhotoSessionRequest request, Authentication auth, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(prepareErrors(bindingResult));
        }
        photoSessionService.createPhotoSession(request, auth);
        return ResponseEntity.ok().build();
    }
    private ValidationErrorResponse prepareErrors(BindingResult bindingResult) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        for (FieldError error : bindingResult.getFieldErrors()) {
            response.addError(error.getField(), error.getDefaultMessage());
        }
        return response;
    }
}
