package com.idat.EFERICKMARQUEZPIZZA.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class Pizzeria {
    private Integer idPizzeria;
    private String direccion;
    private String sede;
}
