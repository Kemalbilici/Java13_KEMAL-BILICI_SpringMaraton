package com.kemal.mapper;

import com.kemal.dto.request.DoktorBransRequestDto;
import com.kemal.dto.request.DoktorSaveRequestDto;
import com.kemal.entity.Brans;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BransMapper {
    BransMapper INSTANCE = Mappers.getMapper(BransMapper.class);

    @Mapping(target = "bransAdi", source = "dto.bransAdi")
    Brans fromDoktorSaveRequestDtoToBrans(DoktorSaveRequestDto dto);

    @Mapping(target = "bransAdi", source = "dto.bransAdi")
    Brans fromDoktorBilgileriRequestDtoToBrans(DoktorBransRequestDto dto);

    Brans fromBransSaveRequestDtoToBrans(DoktorBransRequestDto dto);
}
