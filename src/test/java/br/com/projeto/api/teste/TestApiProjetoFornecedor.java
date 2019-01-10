package br.com.projeto.api.teste;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projeto.api.AplicacaoApplication;
import br.com.projeto.api.model.Fornecedor;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AplicacaoApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class TestApiProjetoFornecedor {

	private static final String API_ROOT = "http://localhost:8080/api/fornecedores";

	private Fornecedor criaFornecedorAleatorio() {
		Fornecedor f = new Fornecedor();
		f.setNome(RandomString.make().concat("cont-"));
		f.setEmail(RandomString.make().concat("@com.br"));
		f.setTelefone(RandomString.make().concat("232323-23233"));
		f.setCnpj(RandomString.make().concat("4546-677"));
		f.setRaz_social(RandomString.make().concat("?"));
		return f;
	}

}
