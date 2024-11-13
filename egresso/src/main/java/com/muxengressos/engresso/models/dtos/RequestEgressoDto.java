package com.muxengressos.engresso.models.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonView
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestEgressoDto implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String resumo;


}
