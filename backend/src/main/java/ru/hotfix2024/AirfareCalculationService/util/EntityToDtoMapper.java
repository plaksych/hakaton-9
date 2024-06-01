package ru.hotfix2024.AirfareCalculationService.util;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.hotfix2024.AirfareCalculationService.model.TicketEntity;
import ru.hotfix2024.AirfareCalculationService.dto.TicketDto;

import ru.hotfix2024.AirfareCalculationService.model.LocationEntity;
import ru.hotfix2024.AirfareCalculationService.dto.LocationDto;

import ru.hotfix2024.AirfareCalculationService.model.UserEntity;
import ru.hotfix2024.AirfareCalculationService.dto.UserDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EntityToDtoMapper {
    UserDto mapUserEntityToDto(UserEntity userEntity);
    UserEntity mapUserDtoToEntity(UserDto userDto);

    LocationDto mapLocationEntityToDto(LocationEntity locationEntity);
    LocationEntity mapLocationDtoToEntity(LocationDto locationDto);

    TicketDto mapTicketEntityToDto(TicketEntity ticketEntity);
    TicketEntity mapTicketDtoToEntity(TicketDto ticketDto);
}
