package com.muxengressos.engresso.services.impl;


import com.muxengressos.engresso.models.ApiResponse;
import com.muxengressos.engresso.models.Egresso;
import com.muxengressos.engresso.models.dtos.RequestEgressoDto;
import com.muxengressos.engresso.repositories.EgressoRepository;
import com.muxengressos.engresso.services.EgressoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class EgressoServiceImpl implements EgressoService {

    @Autowired
    private EgressoRepository egressoRepository;

    private ModelMapper modelMapper;


    @Override
    public Page<RequestEgressoDto> getAllEgresso(Pageable pageable) {
        return egressoRepository.findAll(pageable).map(egresso -> modelMapper.map(egresso, RequestEgressoDto.class));
    }

    @Override
    public RequestEgressoDto getEgressoByCpf(String cpf) {
        return modelMapper.map(egressoRepository.findByCpf(cpf), RequestEgressoDto.class);
    }

    @Override
    public ApiResponse updateEgresso(RequestEgressoDto requestEgressoDto) {
        return null;
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public Egresso save(Egresso egresso) {
        return egressoRepository.save(egresso);
    }

    @Override
    public Optional<Egresso> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void updateEgresso(Egresso egresso, RequestEgressoDto requestEgressoDto) {
        BeanUtils.copyProperties(egresso, requestEgressoDto);

        egresso.setUpdate_at(LocalDateTime.now(ZoneId.of("UTC")));

        egressoRepository.save(egresso);

    }

    @Override
    public Page<Egresso> findAll(Pageable pageable) {
        return egressoRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }
}
