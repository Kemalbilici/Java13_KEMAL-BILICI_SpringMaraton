package com.kemal.dto.request;

import com.kemal.utility.enums.Brans;
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
public class DoktorBransRequestDto {
    private String ad;
    private String soyad;
    @Enumerated(EnumType.STRING)
    private Brans brans;
}
