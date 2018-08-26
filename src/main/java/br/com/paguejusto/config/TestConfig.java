package br.com.paguejusto.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.paguejusto.services.test.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	public boolean instantiateDatabase() throws ParseException {
	
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
}
