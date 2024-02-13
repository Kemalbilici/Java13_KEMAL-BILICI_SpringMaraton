package com.kemal.repository;

import com.kemal.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RandevuRepository extends JpaRepository<Randevu, Long> {

    List<Randevu> findAllByDoktorid(Long id);

}
