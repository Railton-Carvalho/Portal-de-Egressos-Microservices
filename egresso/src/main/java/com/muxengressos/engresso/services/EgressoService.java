package com.muxengressos.engresso.services;


import com.muxengressos.engresso.models.ApiResponse;
import com.muxengressos.engresso.models.Egresso;
import com.muxengressos.engresso.models.dtos.RequestEgressoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface EgressoService {

    Page<RequestEgressoDto> getAllEgresso(Pageable pageable);

    Optional<Egresso> getEgressoByCpf(String cpf);

    ApiResponse updateEgresso(RequestEgressoDto requestEgressoDto);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    Egresso save(Egresso egresso);

    Optional<Egresso> findById(Integer id);

    void updateEgresso(Egresso egresso, RequestEgressoDto requestEgressoDto);

    Page<Egresso> findAll(Specification<Egresso> spec, Pageable pageable);

    boolean existsById(Integer id);
}
