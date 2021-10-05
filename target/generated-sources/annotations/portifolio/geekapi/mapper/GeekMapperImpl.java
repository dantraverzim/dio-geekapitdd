package portifolio.geekapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import portifolio.geekapi.dto.request.GeekDTO;
import portifolio.geekapi.dto.request.GeekDTO.GeekDTOBuilder;
import portifolio.geekapi.entity.Film;
import portifolio.geekapi.entity.Game;
import portifolio.geekapi.entity.Geek;
import portifolio.geekapi.entity.Geek.GeekBuilder;
import portifolio.geekapi.entity.SuperHero;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-03T23:53:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class GeekMapperImpl implements GeekMapper {

    @Override
    public Geek toModel(GeekDTO geekDTO) {
        if ( geekDTO == null ) {
            return null;
        }

        GeekBuilder geek = Geek.builder();

        if ( geekDTO.getBirthDate() != null ) {
            geek.birthDate( LocalDate.parse( geekDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        geek.id( geekDTO.getId() );
        geek.geekName( geekDTO.getGeekName() );
        geek.realName( geekDTO.getRealName() );
        List<Game> list = geekDTO.getFavoriteGame();
        if ( list != null ) {
            geek.favoriteGame( new ArrayList<Game>( list ) );
        }
        List<SuperHero> list1 = geekDTO.getFavoriteSuperHero();
        if ( list1 != null ) {
            geek.favoriteSuperHero( new ArrayList<SuperHero>( list1 ) );
        }
        List<Film> list2 = geekDTO.getFavoriteFilm();
        if ( list2 != null ) {
            geek.favoriteFilm( new ArrayList<Film>( list2 ) );
        }
        geek.hasGlasses( geekDTO.isHasGlasses() );
        geek.favoriteLanguage( geekDTO.getFavoriteLanguage() );
        geek.email( geekDTO.getEmail() );

        return geek.build();
    }

    @Override
    public GeekDTO toDTO(Geek geek) {
        if ( geek == null ) {
            return null;
        }

        GeekDTOBuilder geekDTO = GeekDTO.builder();

        geekDTO.id( geek.getId() );
        geekDTO.geekName( geek.getGeekName() );
        geekDTO.realName( geek.getRealName() );
        List<Game> list = geek.getFavoriteGame();
        if ( list != null ) {
            geekDTO.favoriteGame( new ArrayList<Game>( list ) );
        }
        List<SuperHero> list1 = geek.getFavoriteSuperHero();
        if ( list1 != null ) {
            geekDTO.favoriteSuperHero( new ArrayList<SuperHero>( list1 ) );
        }
        List<Film> list2 = geek.getFavoriteFilm();
        if ( list2 != null ) {
            geekDTO.favoriteFilm( new ArrayList<Film>( list2 ) );
        }
        geekDTO.hasGlasses( geek.isHasGlasses() );
        geekDTO.favoriteLanguage( geek.getFavoriteLanguage() );
        if ( geek.getBirthDate() != null ) {
            geekDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( geek.getBirthDate() ) );
        }
        geekDTO.email( geek.getEmail() );

        return geekDTO.build();
    }
}
