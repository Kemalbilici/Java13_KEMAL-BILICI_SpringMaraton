package com.kemal.service;

import com.kemal.dto.request.DoktorBransRequestDto;
import com.kemal.entity.Brans;
import com.kemal.exception.ErrorType;
import com.kemal.exception.RandevuException;
import com.kemal.mapper.BransMapper;
import com.kemal.repository.BransRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BransService {
    private final BransRepository bransRepository;

    public Brans save(DoktorBransRequestDto dto) {
        Brans brans = BransMapper.INSTANCE.fromBransSaveRequestDtoToBrans(dto);
        Optional<Brans> optionalBrans = bransRepository.findByBransName(brans.getBransName());
        if (optionalBrans.isEmpty()) {
            return bransRepository.save(brans);
        } else {
            throw new RandevuException(ErrorType.DUPLICATE_DOCTOR);
        }
    }

    public List<Brans> findAll() {
        return bransRepository.findAll();
    }

    public Optional<Brans> findById(Long id) {
        return bransRepository.findById(id);
    }

    public Optional<Brans> findByBransName(String bransName) {
        return bransRepository.findByBransName(bransName);
    }
}