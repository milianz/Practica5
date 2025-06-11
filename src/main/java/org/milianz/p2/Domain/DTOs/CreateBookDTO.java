package org.milianz.p2.Domain.DTOs;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDTO {

    @NotBlank(message = "El título no puede estar vacío")
    @Pattern(regexp = "^(?!\\d+$).+", message = "El título no puede contener solo números")
    private String title;

    @NotBlank(message = "El autor no puede estar vacío")
    private String author;

    @NotBlank(message = "El ISBN no puede estar vacío")
    @Pattern(regexp = "^978-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1}$", message = "El ISBN debe tener el formato 978-X-XXXXXX-XXXXXX-X (ISBN-13)")
    private String isbn;

    @NotNull(message = "El año de publicación es obligatorio")
    @Min(value = 1900, message = "El año de publicación debe ser mayor o igual a 1900")
    @Max(value = 2024, message = "El año de publicación no puede ser mayor al año actual")
    private Integer publicationYear;

    private String language; // Campo opcional según los requisitos

    @NotNull(message = "El número de páginas es obligatorio")
    @Min(value = 11, message = "El número de páginas debe ser mayor a 10")
    private Integer pages;

    @NotBlank(message = "El género no puede estar vacío")
    private String genre;
}