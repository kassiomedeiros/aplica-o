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

import br.com.projeto.api.handler.FornecedorNotFoundException;
import br.com.projeto.api.model.Fornecedor;
import br.com.projeto.api.service.FornecedorService;

@Controller
@RequestMapping("/api")
public class FornecedorController {

	@Autowired
	private FornecedorService service;
	
	@GetMapping("/fornecedores")
	public List<Fornecedor>list(){
		List<Fornecedor> fornecedores = this.service.listaFornecedores();
		return fornecedores;
	}
	
	@PostMapping("/fornecedores")
	public void save(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response){
		this.service.save(fornecedor);
	}
	
	@DeleteMapping("/fornecedores")
	public void remove(@RequestBody Fornecedor fornecedor){
		this.service.removeFornecedor(fornecedor);
	}
	
	@DeleteMapping("/fornecedores/{id}")
	public void delete(@PathVariable Long id){
		Fornecedor fornecedor = this.service.getById(id);
		if(fornecedor != null){
			this.service.removeFornecedorById(id);
		}else{
			throw new FornecedorNotFoundException("Fornecedor não encontrado", null);
		}
	}
	
	@PutMapping("/fornecedores")
	public void update(@RequestBody Fornecedor fornecedor){
		this.service.updateFornecedor(fornecedor);
	}
	
	@GetMapping("/fornecedores/{id}")
	public Optional<Fornecedor> buscarPorId(@PathVariable Long id){
		Optional<Fornecedor> fornecedor = this.service.buscaPorId(id);
		return fornecedor;
	}
	
	public Fornecedor buscarPorNome(@PathVariable String nome){
		Fornecedor fornecedor = this.service.buscarPorNome(nome);
		return fornecedor;
	}	
}