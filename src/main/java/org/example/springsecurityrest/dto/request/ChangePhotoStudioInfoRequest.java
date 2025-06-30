package org.example.springsecurityrest.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ChangePhotoStudioInfoRequest {

    private Long id;

    @Size(min = 1, max = 50, message = "Длина адреса должна быть от 1 до 50 символов.")
    private String address;

    @NotBlank(message = "Описание фотостудии должно быть заполнено")
    @Size(min = 1, max = 100, message = "Описание должно быть от 1 до 100 символов.")
    private String title;
}
