package com.idat.EFERICKMARQUEZPIZZA.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class PizzaPizzeriaFK implements Serializable {

    @Column(name="idPizza", nullable = false, unique = false)
    private Integer idPizza;

    @Column(name="idPizzeria", nullable = false, unique = true)
    private Integer idPizzeria;




}
