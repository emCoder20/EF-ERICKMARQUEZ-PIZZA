package com.idat.EFERICKMARQUEZPIZZA.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="pizzeriaPizza")
public class PizzaDetalle {

    @EmbeddedId
    private PizzaPizzeriaFK fk = new PizzaPizzeriaFK();
}
