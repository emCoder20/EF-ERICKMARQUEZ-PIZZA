package com.idat.EFERICKMARQUEZPIZZA.repository;

import com.idat.EFERICKMARQUEZPIZZA.model.PizzaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaDetalleRepository extends JpaRepository<PizzaDetalle, Integer> {
}
