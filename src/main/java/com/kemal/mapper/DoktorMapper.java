package com.kemal.mapper;

import com.kemal.dto.request.DoktorBransRequestDto;
import com.kemal.dto.request.DoktorSaveRequestDto;
import com.kemal.dto.response.DoktorResponseDto;
import com.kemal.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoktorMapper {
    DoktorMapper INSTANCE = Mappers.getMapper(DoktorMapper.class);

    @Mapping(target = "adi", source = "dto.adi")
    @Mapping(target = "soyadi", source = "dto.soyadi")
    Doktor fromDoktorSaveRequestDtoToDoktor(DoktorSaveRequestDto dto);

    @Mapping(target = "adi", source = "dto.adi")
    @Mapping(target = "soyadi", source = "dto.soyadi")
    Doktor fromDoktorBilgileriRequestDtoToDoktor(DoktorBransRequestDto dto);

    DoktorResponseDto fromDoktorToDoktorResponseDto(Doktor doktor);
}
