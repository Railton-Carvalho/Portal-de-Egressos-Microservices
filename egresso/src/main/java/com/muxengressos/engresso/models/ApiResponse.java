package com.muxengressos.engresso.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ApiResponse implements Serializable {

    private boolean sucess;

    private String mensage;


}
