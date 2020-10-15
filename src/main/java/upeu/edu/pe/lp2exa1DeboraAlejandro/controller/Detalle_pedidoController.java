package upeu.edu.pe.lp2exa1DeboraAlejandro.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.lp2exa1DeboraAlejandro.Entity.DetallePedido;
import upeu.edu.pe.lp2exa1DeboraAlejandro.Service.DetallepedidoService;



@RestController
	@RequestMapping("/detalle_pedidos")
public class Detalle_pedidoController {
	@Autowired
	private DetallepedidoService detalle_pedidoService;

@GetMapping("/{id}")
public DetallePedido read (@PathVariable int id) {
	System.out.print(id);
	return detalle_pedidoService.read(id);
	
}

}