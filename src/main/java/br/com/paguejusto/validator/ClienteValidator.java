package br.com.paguejusto.validator;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.domain.enums.TipoCliente;
import br.com.paguejusto.dto.ClienteNewDTO;
import br.com.paguejusto.repositories.ClienteRepository;
import br.com.paguejusto.resources.exception.FieldMessage;
import br.com.paguejusto.validator.utils.CpfOuCnpj;

public class ClienteValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void initialize(ClienteInsert ann) {
	}
	
	@Override
	public boolean isValid(ClienteNewDTO clienteNewDTO, ConstraintValidatorContext context) {
		
	List<FieldMessage> list = new ArrayList<>();
	
	if (clienteNewDTO.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCodigo()) && !CpfOuCnpj.isValidaCPF(clienteNewDTO.getCpfOuCnpj())) {

		list.add(new FieldMessage("cpfOuCnpj","CPF inválido!"));
	}
	
	if (clienteNewDTO.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCodigo()) && !CpfOuCnpj.isValidaCNPJ(clienteNewDTO.getCpfOuCnpj())) {

		list.add(new FieldMessage("cpfOuCnpj","CNPJ inválido!"));
	}
	
	if (clienteNewDTO.getNome()==null) {

		list.add(new FieldMessage("nome","Campo obrigatório!"));
	}
	
	Cliente clienteEmail = clienteRepository.findByEmail(clienteNewDTO.getEmail());
	
	if (clienteEmail !=null) {
		
		list.add(new FieldMessage("email","E-mail já existente!"));
	}
	
	// inclua os testes aqui, inserindo erros na lista
	for (FieldMessage e : list) {
		
	context.disableDefaultConstraintViolation();
	context.buildConstraintViolationWithTemplate(e.getMessage())
	.addPropertyNode(e.getFieldName()).addConstraintViolation();
	}
	return list.isEmpty();
	}

	
	
}
