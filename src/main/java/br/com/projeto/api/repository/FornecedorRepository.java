package br.com.projeto.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	
	public Optional<Fornecedor> findById(Long id);
	
	public Fornecedor findByNome(String nome);

}
