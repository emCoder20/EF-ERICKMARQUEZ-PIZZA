package com.idat.EFERICKMARQUEZPIZZA.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPizza;
    private String nombrePizza;
    private String descripcion;

}
