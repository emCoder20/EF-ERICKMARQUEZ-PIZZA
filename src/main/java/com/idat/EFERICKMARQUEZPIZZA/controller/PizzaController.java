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
    private PizzaServiceImpl pizzaServ;

    @GetMapping("/listar")
    public @ResponseBody ResponseEntity<List<Pizza>> listarPizz(){
        return new ResponseEntity<List<Pizza>>(pizzaServ.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{idPizza}")
    public ResponseEntity<Pizza> buscarPizz(@PathVariable Integer idPizza){
        Pizza pi = pizzaServ.listarPorId(idPizza);
        if(pi!=null) {
            return new ResponseEntity<Pizza>(pi,HttpStatus.OK);
        }
        return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarPizz(@RequestBody Pizza pizza){
        pizzaServ.guardar(pizza);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("actualizar")
    public ResponseEntity<Void> actualizarPizz(@RequestBody Pizza pizza){

        Pizza  pi = pizzaServ.listarPorId(pizza.getIdPizza());

        if(pi!=null) {
            pizzaServ.actualizar(pizza);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{idPizza}")
    public ResponseEntity<Void> eliminarPizz(@PathVariable Integer idPizza){
        Pizza pi = pizzaServ.listarPorId(idPizza);
        if(pi!=null) {
            pizzaServ.eliminar(idPizza);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/asignar")
    public @ResponseBody void asignarPizzeria(){
        pizzaServ.asignarPizzeriaPizza();
    }
}
