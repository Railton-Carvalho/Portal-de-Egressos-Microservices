package com.muxengressos.engresso.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.muxengressos.engresso.models.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_egresso",schema = "egresso")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(of = "id")
public class Egresso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(name = "password", nullable = false, length = 255)
    private String senha;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 50)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "userstatus", nullable = false)
    private UserStatus userStatus;

    @Column(nullable = false)
    private String resumo;

    @Column(length = 255)
    private String url_foto;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;



}
