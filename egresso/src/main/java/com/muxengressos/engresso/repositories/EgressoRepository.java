package com.muxengressos.engresso.repositories;

import com.muxengressos.engresso.models.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EgressoRepository extends JpaRepository<Egresso, Integer>, JpaSpecificationExecutor<Egresso> {

    Optional<Egresso> findByCpf(String cpf);

    boolean existsByNome(String nome);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
