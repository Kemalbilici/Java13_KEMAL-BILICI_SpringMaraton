package com.kemal.service;

import com.kemal.dto.request.DoktorBransRequestDto;
import com.kemal.dto.request.DoktorSaveRequestDto;
import com.kemal.dto.response.DoktorResponseDto;
import com.kemal.entity.Doktor;
import com.kemal.entity.Randevu;
import com.kemal.exception.ErrorType;
import com.kemal.exception.RandevuException;
import com.kemal.mapper.DoktorMapper;
import com.kemal.repository.DoktorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoktorService {

    private final DoktorRepository doktorRepository;

    public DoktorResponseDto save(@Valid DoktorSaveRequestDto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.fromDoktorSaveRequestDtoToDoktor(dto);
        Optional<Doktor> optionalDoktor = doktorRepository.findOptionalByAdAndSoyad(doktor.getAd(), doktor.getSoyad());
        if (optionalDoktor.isEmpty()) {
            doktorRepository.save(doktor);
            return DoktorMapper.INSTANCE.fromDoktorToDoktorResponseDto(doktor);
        } else {
            throw new RandevuException(ErrorType.DUPLICATE_DOCTOR);
        }
    }

    public Doktor update(Doktor doktor) {
        return doktorRepository.save(doktor);
    }

    public Iterable<Doktor> saveAll(Iterable<Doktor> t) {
        return doktorRepository.saveAll(t);
    }

    public Doktor deleteById(Long id) {
        Optional<Doktor> optionalDoktor = doktorRepository.findById(id);
        if (optionalDoktor.isPresent()) {
            return doktorRepository.save(optionalDoktor.get());
        } else {
            throw new RandevuException("Doktor mevcut degil");
        }
    }

    public Optional<Doktor> findById(Long id) {
        Optional<Doktor> doktor = doktorRepository.findById(id);
        if (doktor.isPresent()) {
            return doktor;
        } else {
            throw new RandevuException("Doktorumuz kalmamistir");
        }
    }

    public List<Doktor> findAll() {
        List<Doktor> doktorList = doktorRepository.findAll();
        if (doktorList.isEmpty()) {
            throw new RandevuException("Doktor listesi bos");
        }
        return doktorList;
    }

    public Optional<Doktor> findOptionalByAdAndSoyad(String ad, String soyad) {
        return doktorRepository.findOptionalByAdAndSoyad(ad, soyad);
    }

    public List<Randevu> findAllByDoktorMusaitlik(DoktorBransRequestDto dto) {


        return null;
    }
}

