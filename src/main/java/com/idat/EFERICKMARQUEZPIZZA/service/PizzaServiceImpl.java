package com.idat.EFERICKMARQUEZPIZZA.service;

import com.idat.EFERICKMARQUEZPIZZA.client.OpenFeingClient;
import com.idat.EFERICKMARQUEZPIZZA.dto.Pizzeria;
import com.idat.EFERICKMARQUEZPIZZA.model.Pizza;
import com.idat.EFERICKMARQUEZPIZZA.model.PizzaDetalle;
import com.idat.EFERICKMARQUEZPIZZA.model.PizzaPizzeriaFK;
import com.idat.EFERICKMARQUEZPIZZA.repository.PizzaDetalleRepository;
import com.idat.EFERICKMARQUEZPIZZA.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService{
    @Autowired
    private PizzaRepository repository;

    @Autowired
    private PizzaDetalleRepository detalleRepository;

    @Autowired
    private OpenFeingClient feingClient;

    @Override
    public List<Pizza> listar() {
        return repository.findAll();
    }

    @Override
    public Pizza porId(Integer idPizza) {
        return repository.findById(idPizza).orElse(null);
    }

    @Override
    public void guardar(Pizza pizza) {
        repository.save(pizza);
    }

    @Override
    public void eliminar(Integer idPizza) {
        repository.deleteById(idPizza);
    }

    @Override
    public void actualizar(Pizza pizza) {
        repository.saveAndFlush(pizza);
    }

    @Override
    public void asignarPizzeriaPizza() {
        List<Pizzeria> listado = feingClient.listarPizzeriaSeleccionados();
        PizzaPizzeriaFK fk = null;
        PizzaDetalle detalle = null;

        for (Pizzeria pizzeria: listado) {
            fk = new PizzaPizzeriaFK();
            fk.setIdPizzeria(pizzeria.getIdPizzeria());
            fk.setIdPizza(1);

            detalle = new PizzaDetalle();
            detalle.setFk(fk);
            detalleRepository.save(detalle);
        }
    }

}
