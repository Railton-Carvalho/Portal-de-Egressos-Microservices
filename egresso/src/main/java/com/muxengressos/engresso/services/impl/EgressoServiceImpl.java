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
}
