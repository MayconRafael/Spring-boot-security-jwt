package com.br.backend.entity;

public enum UsuarioCargo {
    ADMIN("ADMIN"),
    USER("USER");

    private String cargo;

    UsuarioCargo(String c){
        this.cargo = c;
    }

    public String getCargo(){
        return cargo;
    }

}
