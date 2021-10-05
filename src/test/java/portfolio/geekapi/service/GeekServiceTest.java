package portfolio.geekapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import portfolio.geekapi.builder.GeekDTOBuilder;
import portifolio.geekapi.dto.request.GeekDTO;
import portifolio.geekapi.entity.Geek;
import portifolio.geekapi.exception.GeekAlreadyRegisteredException;
import portifolio.geekapi.mapper.GeekMapper;
import portifolio.geekapi.repository.GeekRepository;
import portifolio.geekapi.service.GeekService;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GeekServiceTest {

    @Mock
    private GeekRepository geekRepository;

    private final GeekMapper geekMapper = GeekMapper.INSTANCE;

    @InjectMocks
    private GeekService geekService;

    @Test
    void whenGeekInformedThenItShouldBeCreated() throws GeekAlreadyRegisteredException {
        // given
        GeekDTO expectedGeekDTO = GeekDTOBuilder.builder().build().toGeekDTO();
        Geek expectedSavedGeek = geekMapper.toModel(expectedGeekDTO);

        // when
        when(geekRepository.findByName(expectedGeekDTO.getGeekName())).thenReturn(Optional.empty());
        when(geekRepository.save(expectedSavedGeek)).thenReturn(expectedSavedGeek);

        //then
        GeekDTO createdGeekDTO = geekService.createGeekByName(expectedGeekDTO);

        assertThat(createdGeekDTO.getId(),  is(equalTo(expectedGeekDTO.getId())));
        assertThat(createdGeekDTO.getGeekName(), is(equalTo(expectedGeekDTO.getGeekName())));
        assertThat(createdGeekDTO.getRealName(), is(equalTo(expectedGeekDTO.getRealName())));
    }

}