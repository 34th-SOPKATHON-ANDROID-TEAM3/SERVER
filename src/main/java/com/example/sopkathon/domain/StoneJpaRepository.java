package com.example.sopkathon.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoneJpaRepository extends JpaRepository<Stone, Long> {
    Stone findFirstByOrderByIdDesc();

    List<Stone> findAllByOrderById();
}
