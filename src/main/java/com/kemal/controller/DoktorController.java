package com.kemal.controller;

import com.kemal.dto.request.DoktorBransRequestDto;
import com.kemal.dto.request.DoktorSaveRequestDto;
import com.kemal.dto.response.DoktorResponseDto;
import com.kemal.entity.Doktor;
import com.kemal.entity.Randevu;
import com.kemal.service.DoktorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kemal.utility.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doktor")
public class DoktorController {
    private final DoktorService doktorService;

    @PostMapping(SAVE)
    public ResponseEntity<DoktorResponseDto> save(@RequestBody @Valid DoktorSaveRequestDto dto){
        return ResponseEntity.ok(doktorService.save(dto));
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<List<Doktor>> getAll(){
        return ResponseEntity.ok( doktorService.findAll());
    }

    @PostMapping(GET_RANDEVULAR_BY_DOKTOR_MUSAITLIK)
    public ResponseEntity<List<Randevu>> getAllByDoktorMusaitlik(@RequestBody @Valid DoktorBransRequestDto dto){
        return ResponseEntity.ok(doktorService.findAllByDoktorMusaitlik(dto));
    }
}
