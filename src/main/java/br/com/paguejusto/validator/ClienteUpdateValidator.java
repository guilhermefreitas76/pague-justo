package br.com.paguejusto.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.dto.ClienteDTO;
import br.com.paguejusto.repositories.ClienteRepository;
import br.com.paguejusto.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	public void initialize(ClienteUpdate ann) {
	}
	
	@Override
	public boolean isValid(ClienteDTO clienteDTO, ConstraintValidatorContext context) {
		
	@SuppressWarnings("unchecked")
	Map<String,String> map = (Map<String, String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);	
	
	Long idCliente = Long.parseLong(map.get("id"));
		
	List<FieldMessage> list = new ArrayList<>();
		
	Cliente clienteEmail = clienteRepository.findByEmail(clienteDTO.getEmail());
	
	if (clienteEmail !=null && !clienteEmail.getId().equals(idCliente)) {
		
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
