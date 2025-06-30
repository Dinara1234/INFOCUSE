package org.example.springsecurityrest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "Используется при подаче запроса на создание фотосессии.",
        example = "{\"title\": \"Фотосессия в поле\", \"quantityOfModels\": 2,  \"photographerId\": 2, \"photoStudioId\": 2, \"timeStart\": \"2025-06-14 11:30:00.000000\", \"timeEnd\": \"2025-06-14 12:30:00.000000\"}")
public class CreatePhotoSessionRequest {

    @Size(min = 2, max = 100, message = "Описание должно содержать от 2 до 100 символов")
    private String title;
    @NotNull(message = "Дата и время не может быть null")
    private LocalDateTime timeStart;

    @NotNull(message = "Дата и время не может быть null")
    private LocalDateTime timeEnd;

    @Min(value = 1, message = "Количество моделей должно быть минимум 1.")
    @Max(value = 28, message = "Количество моделей должно быть максимум 15.")
    private Integer quantityOfModels;

    @NotNull(message = "photographerId не может быть null")
    private Long photographerId;

    @NotNull(message = "photoStudioId не может быть null")
    private Long photoStudioId;


}
