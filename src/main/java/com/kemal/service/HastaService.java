package com.kemal.service;

import com.kemal.entity.Hasta;
import com.kemal.exception.RandevuException;
import com.kemal.repository.HastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HastaService {

    private final HastaRepository hastaRepository;

    public Hasta save(Hasta hasta) {
        return hastaRepository.save(hasta);
    }

    public Hasta update(Hasta hasta) {
        return hastaRepository.save(hasta);
    }

    public Iterable<Hasta> saveAll(Iterable<Hasta> t) {
        return hastaRepository.saveAll(t);
    }

    public Hasta deleteById(Long id) {
        Optional<Hasta> optionalHasta = hastaRepository.findById(id);
        if (optionalHasta.isPresent()) {
            hastaRepository.deleteById(id);
            return optionalHasta.get();
        } else {
            throw new RandevuException("Hasta yok");
        }
    }

    public Optional<Hasta> findById(Long id) {
        return hastaRepository.findById(id);
    }

    public List<Hasta> findAll() {
        List<Hasta> hastaList = hastaRepository.findAll();
        if (hastaList.isEmpty()) {
            throw new RandevuException("Hasta listesi bos");
        }
        return hastaList;
    }
}
