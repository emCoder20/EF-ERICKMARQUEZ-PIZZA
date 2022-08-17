package com.idat.EFERICKMARQUEZPIZZA.repository;

import com.idat.EFERICKMARQUEZPIZZA.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
