package portifolio.geekapi.mapper;

import org.mapstruct.factory.Mappers;
import portifolio.geekapi.dto.request.GeekDTO;
import portifolio.geekapi.entity.Geek;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(componentModel="spring")
@Mapper
public interface GeekMapper {

    GeekMapper INSTANCE = Mappers.getMapper(GeekMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Geek toModel(GeekDTO geekDTO);

    GeekDTO toDTO(Geek geek);
}