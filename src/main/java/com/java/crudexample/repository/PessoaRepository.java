package com.java.crudexample.repository;

import java.util.List;

import com.java.crudexample.models.Pessoa;

public interface PessoaRepository {
    List<Pessoa> findAll();

    Pessoa findById(Long id);

    void save(Pessoa pessoa);

    void update(Long id, Pessoa updatedPerson);

    void delete(Long id);
}