package portifolio.geekapi.dto.request;

import portifolio.geekapi.entity.Film;
import portifolio.geekapi.entity.Game;
import portifolio.geekapi.entity.SuperHero;
import portifolio.geekapi.enums.ProgrammingLanguageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeekDTO {

    private Long id;

    @NotEmpty(message = "Provide your GEEK name")
    @Size(min = 2, max = 100)
    private String geekName;

    @NotEmpty(message = "Provide your name")
    @Size(min = 2, max = 100)
    private String realName;

    @Valid
    private List<Game> favoriteGame;

    @Valid
    private List<SuperHero> favoriteSuperHero;

    @Valid
    private List<Film> favoriteFilm;

    private boolean hasGlasses;

    @Enumerated(EnumType.STRING)
    private ProgrammingLanguageType favoriteLanguage;

    private String birthDate;

    @Email
    @Size(max = 200)
    private String email;

}