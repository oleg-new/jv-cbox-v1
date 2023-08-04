package com.olegnew.jvcboxv1.controller;

import com.olegnew.jvcboxv1.dto.CboxResponseDto;
import com.olegnew.jvcboxv1.dto.FullInformationRequestDto;
import com.olegnew.jvcboxv1.dto.FullInformationResponseDto;
import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import com.olegnew.jvcboxv1.service.cbox.CboxService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cbox")
@RequiredArgsConstructor
@Tag(name = "Cbox Controller", description = "The controller allows you to create, modify, "
        + "reboot, delete a Cbox.\n Allows you to get a list of all Cboxs, get a user by ID.\n +"
        + " Контроллер позволяет создавать, изменять, перезагрузить, удалять Cbox.\n"
        + "Позволяет получить список всех Cbox, получить Cbox по ID")
public class CboxController {
    private final CboxService cboxService;
    private final ModelMapper modelMapper;

    @Operation(summary = "Gets all Cboxs", tags = "Cbox Controller")
    @Schema(title = "List all Cboxs")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List all Cboxs",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    @GetMapping("/")
    public List<CboxResponseDto> getAllCbox() {
        List<Cbox> cboxes = cboxService.getAllCboxs();
        List<CboxResponseDto> cboxResponseDtoList = cboxes.stream()
                .map(u -> modelMapper.map(u, CboxResponseDto.class))
                .collect(Collectors.toList());
        return cboxResponseDtoList;
    }

    @Operation(summary = "Get Cbox by ID", tags = "User Controller")
    @Schema(title = "Get Cbox by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found Cbox by Id",
                    content = {
                            @Content(
                                    mediaType = "application/json"),
                    })
    })
    @GetMapping("/{id}")
    public FullInformationResponseDto getById(@PathVariable
                                                  @ApiParam(
                                                          name = "Cbox ID",
                                                          type = "Long",
                                                          value = "ID of the Cbox  "
                                                                  + "you are looking for",
                                                          example = "1")
                                                  Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // only the OERATOR can get information about the "community"
        boolean hasOperatorRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_OPERATOR"));
        System.out.println(hasOperatorRole);
        return modelMapper.map(cboxService.getFullInformation(id, hasOperatorRole),
                FullInformationResponseDto.class);
    }

    @Operation(summary = "Adding a new Cbox", tags = "Cbox Controller")
    @Schema(title = "Adding a new Cbox")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Data other than default Cbox, street, house,"
                            + " {list of values received from device}",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    @PostMapping("/add")
    public FullInformationResponseDto add(@RequestBody
                                              @ApiParam(
                                                      name = "User ",
                                                      type = "User",
                                                      value = "Data other than default Cbox, "
                                                              + "street, house,"
                                                              + "{list of values to be "
                                                              + "set on the device}")
                                              FullInformationRequestDto
                                                      fullInformationRequestDto) {
        FullInformation fullInformation = modelMapper.map(fullInformationRequestDto,
                FullInformation.class);
        return modelMapper.map(cboxService.add(fullInformation),FullInformationResponseDto.class);
    }

    @Operation(summary = "Reboot Cbox by ID", tags = "Cbox Controller")
    @Schema(title = "Reboot Cbox by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ok",
                    content = {
                            @Content(
                                    mediaType = "application/json"),
                    })
    })
    @PostMapping("/reboot")
    public String reboot(@RequestBody
                             @ApiParam(
                                     name = "Cbox ID",
                                     type = "Long",
                                     value = "ID of the Cbox to be Rebooted",
                                     example = "2")
                             Long id) {
        Cbox cbox = cboxService.getById(id).get();
        cboxService.rebootDevice(cbox);
        return "Rebooting";
    }

    @Operation(summary = "Update Cbox by ID", tags = "Cbox Controller")
    @Schema(title = "Update Cbox by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated Cbox data, street, house, "
                            + "{list of values received from device}",
                    content = {
                            @Content(
                                    mediaType = "application/json"),
                    })
    })
    @PatchMapping("/update/{id}")
    public FullInformationResponseDto update(@Valid @PathVariable
                                                 @ApiParam(
                                                         name = "Cbox ID",
                                                         type = "Long",
                                                         value = "ID of the Cbox to be upated",
                                                         example = "1")String id,
                                             @RequestBody
                                             @ApiParam(
                                                     name = "User",
                                                     type = "Long",
                                                     value = "Updated Data other "
                                                             + "than current Cbox, street, house, "
                                                             + "{list of values to be "
                                                     + "set on the device}")
                                             FullInformationRequestDto
                                                     fullInformationRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // only the OERATOR can get information about the "community"
        boolean hasOperatorRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_OPERATOR"));
        cboxService.updateById(Long.parseLong(id), modelMapper.map(fullInformationRequestDto,
                FullInformation.class), false);
        return modelMapper.map(cboxService.getFullInformation(Long.parseLong(id), hasOperatorRole),
                FullInformationResponseDto.class);
    }

    @Operation(summary = "Delete Cbox by ID", tags = "Cbox Controller")
    @Schema(title = "Delete Cbox by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ok",
                    content = {
                            @Content(
                                    mediaType = "application/json"),
                    })
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable
                           @ApiParam(
                                   name = "Cbox ID",
                                   type = "Long",
                                   value = "ID of the Cbox to be deleted",
                                   example = "2")
                           Long id) {
        cboxService.delete(id);
    }
}
