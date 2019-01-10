package br.com.projeto.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.api.handler.ClienteNotFoundException;
import br.com.projeto.api.model.Cliente;
import br.com.projeto.api.service.ClienteService;

@Controller
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/clientes")
	public List<Cliente>list(){
		List<Cliente> clientes =  this.service.listClientes();
		return clientes;		
	}
	
	@PostMapping("/clientes")
	public void save (@Valid @RequestBody Cliente cliente, HttpServletResponse response){
		this.service.save(cliente);
	}

	@DeleteMapping("/clientes")
	public void remove(@RequestBody Cliente cliente){
		this.service.removeCliente(cliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void delete(@PathVariable Long id){
		Cliente cliente = service.getById(id);
		if(cliente != null){
			service.removeClienteById(id);
		}else{
			throw new ClienteNotFoundException("Cliente não encontrado", null);
		}
	}
	
	@PutMapping("/clientes")
	public void update(@RequestBody Cliente cliente){
		this.service.updateCliente(cliente);
	}
	
	@GetMapping("/clientes/{id}")
	public Optional<Cliente> buscarPorId(@PathVariable Long id){
		Optional<Cliente> cliente = this.service.buscarPorId(id);
		return cliente;
	}
	
	@GetMapping("/clientes/nome")
	public Cliente buscaPorNome(@PathVariable String nome){
		Cliente cliente = this.service.buscarPorNome(nome);
		return cliente;
	}
}