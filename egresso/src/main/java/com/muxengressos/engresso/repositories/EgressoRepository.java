package com.muxengressos.engresso.repositories;

import com.muxengressos.engresso.models.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EgressoRepository extends JpaRepository<Egresso, Integer> {

    Optional<Egresso> findByCpf(String cpf);

}
