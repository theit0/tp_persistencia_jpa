package com.dds.tp_persistencia_jpa.entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
