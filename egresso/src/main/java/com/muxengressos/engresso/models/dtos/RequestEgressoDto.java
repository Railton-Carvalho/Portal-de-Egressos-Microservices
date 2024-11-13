package com.muxengressos.engresso.models.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestEgressoDto implements Serializable {

    public interface EgressoView{
        public static interface RegistrationPost{}
        public static interface EgressoUpdate {}
        public static interface PasswordUpdate {}
        public static interface ImageUpdate {}
    }

    private Integer id;

    @NotBlank
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    private String nome;

    @NotBlank
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    private String cpf;

    @NotBlank
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    private String email;

    @NotBlank
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.PasswordUpdate.class})
    private String senha;

    @NotBlank
    @JsonView(EgressoView.PasswordUpdate.class)
    private String old_senha;

    private String resumo;

    @JsonView({EgressoView.ImageUpdate.class})
    private String url_foto;


}
