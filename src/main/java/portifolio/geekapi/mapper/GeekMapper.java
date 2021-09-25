package portifolio.geekapi.mapper;

import portifolio.geekapi.dto.request.GeekDTO;
import portifolio.geekapi.entity.Geek;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface GeekMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Geek toModel(GeekDTO geekDTO);

    GeekDTO toDTO(Geek geek);
}