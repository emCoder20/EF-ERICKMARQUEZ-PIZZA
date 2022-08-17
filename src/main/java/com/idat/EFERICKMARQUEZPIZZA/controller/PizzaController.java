package com.idat.EFERICKMARQUEZPIZZA.controller;

import com.idat.EFERICKMARQUEZPIZZA.model.Pizza;
import com.idat.EFERICKMARQUEZPIZZA.service.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaServiceImpl pizzaImpl;

    @GetMapping("/listar")
    public @ResponseBody ResponseEntity<List<Pizza>> listarP(){
        return new ResponseEntity<List<Pizza>>(pizzaImpl.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{idPizza}")
    public ResponseEntity<Pizza> buscarP(@PathVariable Integer idPizza){
        Pizza pi = pizzaImpl.porId(idPizza);
        if(pi!=null) {
            return new ResponseEntity<Pizza>(pi,HttpStatus.OK);
        }
        return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarP(@RequestBody Pizza pizza){
        pizzaImpl.guardar(pizza);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("actualizar")
    public ResponseEntity<Void> actualizarP(@RequestBody Pizza pizza){

        Pizza  pi = pizzaImpl.porId(pizza.getIdPizza());

        if(pi!=null) {
            pizzaImpl.actualizar(pizza);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{idPizza}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idPizza){
        Pizza pi = pizzaImpl.porId(idPizza);
        if(pi!=null) {
            pizzaImpl.eliminar(idPizza);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/asignar")
    public @ResponseBody void asignarPizzeria(){
        pizzaImpl.asignarPizzeriaPizza();
    }
}
