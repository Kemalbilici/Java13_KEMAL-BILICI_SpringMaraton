package com.kemal.dto.response;

import com.kemal.utility.enums.Cinsiyet;
import com.kemal.utility.enums.Musaitlik;
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

public class RandevuResponseDto {
    private String doktorAdi;
    private String hastaAdi;
    private String tarih;
    @Enumerated(EnumType.STRING)
    private Musaitlik musaitlik;
    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;
}