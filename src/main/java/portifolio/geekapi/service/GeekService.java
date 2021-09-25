package portifolio.geekapi.service;

import portifolio.geekapi.dto.request.GeekDTO;
import portifolio.geekapi.dto.response.MessageResponseDTO;
import portifolio.geekapi.entity.Geek;
import portifolio.geekapi.exception.GeekNotFoundException;
import portifolio.geekapi.mapper.GeekMapper;
import portifolio.geekapi.repository.GeekRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GeekService {

    private GeekRepository geekRepository;

    private final GeekMapper geekMapper;

    public MessageResponseDTO createGeek(GeekDTO geekDTO) {
        Geek geekToSave = geekMapper.toModel(geekDTO);
        Geek savedGeek = geekRepository.save(geekToSave);
        return createMessageResponse(savedGeek.getId(), "Geek created at ID --> ");
    }

    public List<GeekDTO> listAll() {
        List<Geek> allGeeks = geekRepository.findAll();
        return allGeeks.stream()
                .map(geekMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GeekDTO findById(Long id) throws GeekNotFoundException {
        Geek geek = verifyIfExists(id);
        return geekMapper.toDTO(geek);
    }

    public void delete(Long id) throws GeekNotFoundException {
        verifyIfExists(id);
        geekRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, GeekDTO geekDTO) throws GeekNotFoundException {
        verifyIfExists(id);
        Geek geekToUpdate = geekMapper.toModel(geekDTO);
        Geek updatedGeek = geekRepository.save(geekToUpdate);
        return createMessageResponse(updatedGeek.getId(), "Geek updated at ID --> ");
    }

    private Geek verifyIfExists(Long id) throws GeekNotFoundException {
        return geekRepository.findById(id)
                .orElseThrow(() -> new GeekNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
