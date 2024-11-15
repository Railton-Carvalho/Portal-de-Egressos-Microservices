package com.muxengressos.engresso.models.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestEgressoDto implements Serializable {

    public interface EgressoView{
        public static interface RegistrationPost{}
        public static interface EgressoUpdate {}
        public static interface PasswordUpdate {}
        public static interface ImageUpdate {}
    }

    private Integer id;

    @NotBlank(groups = {EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    private String nome;

    @NotBlank(groups = {EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    private String cpf;

    @NotBlank(groups = {EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    private String email;

    @NotBlank(groups = {EgressoView.RegistrationPost.class, EgressoView.PasswordUpdate.class})
    @JsonView({EgressoView.RegistrationPost.class, EgressoView.PasswordUpdate.class})
    private String senha;

    @NotBlank(groups = EgressoView.PasswordUpdate.class)
    @JsonView(EgressoView.PasswordUpdate.class)
    private String old_senha;

    @JsonView({EgressoView.RegistrationPost.class, EgressoView.EgressoUpdate.class})
    private String resumo;

    @NotBlank(groups = EgressoView.ImageUpdate.class)
    @JsonView({EgressoView.ImageUpdate.class})
    private String url_foto;


}
