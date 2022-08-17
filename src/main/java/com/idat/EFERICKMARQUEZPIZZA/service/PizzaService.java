package com.idat.EFERICKMARQUEZPIZZA.service;

import com.idat.EFERICKMARQUEZPIZZA.model.Pizza;

import java.util.List;

public interface PizzaService {

    List<Pizza> listar();
    Pizza porId(Integer idPizza);
    void guardar(Pizza pizza);
    void eliminar(Integer idPizza);
    void actualizar(Pizza pizza);
    void asignarPizzeriaPizza();
}
