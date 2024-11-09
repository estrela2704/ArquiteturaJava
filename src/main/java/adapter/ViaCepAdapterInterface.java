package adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.felipe.domain.usuario.Endereco;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://viacep.com.br/ws", name = "viaCepAdapter")
public interface ViaCepAdapterInterface {

	@GetMapping(value = "/{cep}/json/")
	Endereco findByCep(@PathVariable String cep);
}