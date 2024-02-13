package com.kemal.service;

import com.kemal.entity.Randevu;
import com.kemal.exception.RandevuException;
import com.kemal.repository.RandevuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandevuService {

    private final RandevuRepository randevuRepository;

    public Randevu save(Randevu randevu) {
        return randevuRepository.save(randevu);
    }

    public List<Randevu> findAllByDoktorid(Long id) {
        return randevuRepository.findAllByDoktorid(id);
    }

    public List<Randevu> findAll() {
        List<Randevu> randevuList = randevuRepository.findAll();
        if (randevuList.isEmpty()) {
            throw new RandevuException("Randevu listesi boş.");
        }
        return randevuList;
    }

    public Optional<Randevu> findById(Long id) {
        return randevuRepository.findById(id);
    }

    public void deleteById(Long id) {
        randevuRepository.deleteById(id);
    }
}