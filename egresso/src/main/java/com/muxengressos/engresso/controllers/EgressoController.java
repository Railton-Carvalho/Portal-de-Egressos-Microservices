package com.muxengressos.engresso.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import com.muxengressos.engresso.models.ApiResponse;
import com.muxengressos.engresso.models.Egresso;
import com.muxengressos.engresso.models.dtos.RequestEgressoDto;
import com.muxengressos.engresso.models.enums.UserStatus;
import com.muxengressos.engresso.services.EgressoService;
import com.muxengressos.engresso.specifications.SpecificationTemplate;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@RequestMapping("v1/egresso")
public class EgressoController {

    @Autowired
    private EgressoService egressoService;

    private ModelMapper modelMappper = new ModelMapper();


    @GetMapping
    public ResponseEntity<Page<RequestEgressoDto>> getAllEgresso(
            SpecificationTemplate.EgressoSpec spec,
            @PageableDefault(size = 10, sort = "id")  Pageable pageable){

        var egressolist = egressoService.findAll(spec, pageable).map(egresso -> modelMappper.map(egresso, RequestEgressoDto.class));

        return ResponseEntity.ok().body(egressolist);
    }


    @PostMapping
    public ResponseEntity<Object> registrerEgresso(@RequestBody
                                                            @JsonView(RequestEgressoDto.EgressoView.RegistrationPost.class) RequestEgressoDto requestEgressoDto){

        if (!egressoService.existsByCpf(requestEgressoDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, "CPF já cadastrado !!!"));
        }
        if (!egressoService.existsByEmail(requestEgressoDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, "Email fornecido já cadastrado !!!"));
        }

        var egresso = new Egresso();
        BeanUtils.copyProperties(requestEgressoDto, egresso);
        egresso.setUserStatus(UserStatus.ACTIVE);
        egresso.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        egresso.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        egressoService.save(egresso);

        return ResponseEntity.status(HttpStatus.CREATED).body(egresso);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Object> updateEgresso(@RequestBody @JsonView(RequestEgressoDto.EgressoView.EgressoUpdate.class) RequestEgressoDto requestEgressoDto){

        var egressoOptional = egressoService.findById(requestEgressoDto.getId());
        if (egressoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Egresso não encontrado"));
        }
        egressoService.updateEgresso(egressoOptional.get(), requestEgressoDto);

        return ResponseEntity.ok().body(new ApiResponse(true, "id: "+requestEgressoDto.getId()+"- Egresso Atualizado !"));
    }

    @Transactional
    @PatchMapping("/updatepass")
    public ResponseEntity<ApiResponse> updatePassword(@RequestBody @JsonView(RequestEgressoDto.EgressoView.PasswordUpdate.class) RequestEgressoDto requestEgressoDto){

        if (!egressoService.existsById(requestEgressoDto.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, "ID não encontrado"));
        }

        return ResponseEntity.ok().body(new ApiResponse(true, "Senha atualizada"));

    }
}
