package com.kemal.dto.request;

import com.kemal.utility.enums.Brans;
import com.kemal.utility.enums.Unvan;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DoktorSaveRequestDto {


    private Long id;
    private String doktorAdi;
}