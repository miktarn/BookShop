package mik.pet.project.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBookRequestDto {
    @NotNull
    @Length(min = 3, max = 100)
    private String title;
    @NotNull
    @Length(min = 5, max = 100)
    private String author;
    @NotNull
    @ISBN
    private String isbn;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @Length(min = 30, max = 500)
    private String description;
    @Length(min = 5, max = 300)
    private String coverImage;
}
