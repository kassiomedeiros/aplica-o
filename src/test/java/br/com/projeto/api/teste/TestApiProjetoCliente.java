package br.com.projeto.api.teste;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projeto.api.AplicacaoApplication;
import br.com.projeto.api.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AplicacaoApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class TestApiProjetoCliente {

	private static final String API_ROOT = "http://localhost:8080/api/clientes";

	private Cliente criaClienteAleatorio() {
		Cliente c = new Cliente();
		c.setNome(RandomString.make().concat("contato-"));
		c.setEmail(RandomString.make().concat("@com.br"));
		c.setTelefone(RandomString.make().concat("232323-23233"));
		c.setCpf(RandomString.make().concat("4546-677"));
		return c;
	}
}