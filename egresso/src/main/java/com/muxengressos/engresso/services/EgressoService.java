package com.muxengressos.engresso.services;


import com.muxengressos.engresso.models.ApiResponse;
import com.muxengressos.engresso.models.dtos.RequestEgressoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EgressoService {

    Page<RequestEgressoDto> getAllEgresso(Pageable pageable);

    RequestEgressoDto getEgressoByCpf(String cpf);

    ApiResponse updateEgresso(RequestEgressoDto requestEgressoDto);


}
