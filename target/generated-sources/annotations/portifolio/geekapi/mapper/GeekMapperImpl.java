package portifolio.geekapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import portifolio.geekapi.dto.request.GeekDTO;
import portifolio.geekapi.entity.Film;
import portifolio.geekapi.entity.Game;
import portifolio.geekapi.entity.Geek;
import portifolio.geekapi.entity.SuperHero;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-28T00:47:05-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class GeekMapperImpl implements GeekMapper {

    @Override
    public Geek toModel(GeekDTO geekDTO) {
        if ( geekDTO == null ) {
            return null;
        }

        Geek geek = new Geek();

        if ( geekDTO.getBirthDate() != null ) {
            geek.setBirthDate( LocalDate.parse( geekDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        geek.setId( geekDTO.getId() );
        geek.setGeekName( geekDTO.getGeekName() );
        geek.setRealName( geekDTO.getRealName() );
        List<Game> list = geekDTO.getFavoriteGame();
        if ( list != null ) {
            geek.setFavoriteGame( new ArrayList<Game>( list ) );
        }
        List<SuperHero> list1 = geekDTO.getFavoriteSuperHero();
        if ( list1 != null ) {
            geek.setFavoriteSuperHero( new ArrayList<SuperHero>( list1 ) );
        }
        List<Film> list2 = geekDTO.getFavoriteFilm();
        if ( list2 != null ) {
            geek.setFavoriteFilm( new ArrayList<Film>( list2 ) );
        }
        geek.setHasGlasses( geekDTO.isHasGlasses() );
        geek.setFavoriteLanguage( geekDTO.getFavoriteLanguage() );
        geek.setEmail( geekDTO.getEmail() );

        return geek;
    }

    @Override
    public GeekDTO toDTO(Geek geek) {
        if ( geek == null ) {
            return null;
        }

        GeekDTO geekDTO = new GeekDTO();

        geekDTO.setId( geek.getId() );
        geekDTO.setGeekName( geek.getGeekName() );
        geekDTO.setRealName( geek.getRealName() );
        List<Game> list = geek.getFavoriteGame();
        if ( list != null ) {
            geekDTO.setFavoriteGame( new ArrayList<Game>( list ) );
        }
        List<SuperHero> list1 = geek.getFavoriteSuperHero();
        if ( list1 != null ) {
            geekDTO.setFavoriteSuperHero( new ArrayList<SuperHero>( list1 ) );
        }
        List<Film> list2 = geek.getFavoriteFilm();
        if ( list2 != null ) {
            geekDTO.setFavoriteFilm( new ArrayList<Film>( list2 ) );
        }
        geekDTO.setHasGlasses( geek.isHasGlasses() );
        geekDTO.setFavoriteLanguage( geek.getFavoriteLanguage() );
        if ( geek.getBirthDate() != null ) {
            geekDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( geek.getBirthDate() ) );
        }
        geekDTO.setEmail( geek.getEmail() );

        return geekDTO;
    }
}
