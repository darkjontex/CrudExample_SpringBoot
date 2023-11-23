package com.java.crudexample.resources;

	
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.crudexample.models.Pessoa;
import com.java.crudexample.repository.PessoaRepository;

@RestController
@RequestMapping("/api/people")
public class PessoaResource {
    private final PessoaRepository pessoaRepository;

    public PessoaResource(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public List<Pessoa> getAllPeople() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa getPersonById(@PathVariable Long id) {    	
        return pessoaRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody Pessoa pessoa) {
    	pessoaRepository.save(pessoa);
    	return new ResponseEntity<String>(pessoa.getName().toString() + " Cadastrado(a) com sucesso!", HttpStatus.CREATED); 	
    	 
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody Pessoa updatedPerson) {
    	if(pessoaRepository.findById(id) != null) {
    		pessoaRepository.update(id, updatedPerson);
    		return new ResponseEntity<String>("Dados da pessoa '"+ 
    				pessoaRepository.findById(id).getName().toString() +"' atualizados com Sucesso!",HttpStatus.ACCEPTED);
    	}
		return new ResponseEntity<String>("Os dados informados estão fora do padrão ou não existem", HttpStatus.BAD_REQUEST); 	
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
    	pessoaRepository.delete(id);
    }

}
