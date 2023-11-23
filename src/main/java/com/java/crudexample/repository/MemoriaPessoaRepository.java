package com.java.crudexample.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.crudexample.models.Pessoa;

@Repository
public class MemoriaPessoaRepository implements PessoaRepository {
	
	    private List<Pessoa> people = new ArrayList<>();
	    private Long nextId = 1L;

	    public List<Pessoa> findAll() {
	        return new ArrayList<>(people);
	    }

	    public Pessoa findById(Long id) {
	    	for (Pessoa Pessoa : people) {
	            if (Pessoa.getId().equals(id)) {
	                return Pessoa;
	            }
	        }
	        return null;
	    }

	    public void save(Pessoa Pessoa) {
	        Pessoa.setId(nextId);
	        nextId++;
	        people.add(Pessoa);
	    }

	    public void update(Long id, Pessoa updatedPessoa) {
	        for (int i = 0; i < people.size(); i++) {
	            if (people.get(i).getId().equals(id)) {
	                updatedPessoa.setId(id);
	                people.set(i, updatedPessoa);
	                return;
	            }
	        }
	    }

	    public void delete(Long id) {
	        people.removeIf(Pessoa -> Pessoa.getId().equals(id));
	    }
	


}
