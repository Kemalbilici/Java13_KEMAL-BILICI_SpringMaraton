package com.kemal.dto.response;

import com.kemal.utility.enums.Brans;
import com.kemal.utility.enums.Unvan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoktorResponseDto {
    private Long id;
    private String ad;
    private String soyad;
    private Brans brans;
    private Unvan unvan;
}