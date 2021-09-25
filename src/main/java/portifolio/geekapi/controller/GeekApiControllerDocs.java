package portifolio.geekapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import portifolio.geekapi.dto.request.GeekDTO;
import portifolio.geekapi.exception.GeekAlreadyRegisteredException;
import portifolio.geekapi.exception.GeekNotFoundException;

import java.util.List;

@Api
public interface GeekApiControllerDocs {

    @ApiOperation(value = "Geek creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success geek creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    GeekDTO createGeek(GeekDTO geekDTO) throws GeekAlreadyRegisteredException;

    @ApiOperation(value = "Returns geek found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success geek found in the system"),
            @ApiResponse(code = 404, message = "Geek with given name not found.")
    })
    GeekDTO findByName(@PathVariable String name) throws GeekNotFoundException;

    @ApiOperation(value = "Returns a list of all geek registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all geek registered in the system"),
    })
    List<GeekDTO> listGeeks();

    @ApiOperation(value = "Delete a geek found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success geek deleted in the system"),
            @ApiResponse(code = 404, message = "Geek with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws GeekNotFoundException;

}
