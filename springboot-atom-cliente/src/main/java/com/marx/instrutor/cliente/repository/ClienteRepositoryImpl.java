package com.marx.instrutor.cliente.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.marx.instrutor.cliente.repository.util.FiltroPesquisa;
import com.marx.instrutor.data.Cliente;

@PersistenceUnit
@Transactional
@Repository
public class ClienteRepositoryImpl extends GenericDAO<Cliente, Serializable> {

	public ClienteRepositoryImpl() {
		super(Cliente.class);
	}

	public List<Cliente> obterClientePorCpf(String cpf) {
		FiltroPesquisa<Cliente> filtroPesquisa = new FiltroPesquisa<Cliente>() {			
			@Override
	        public Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root<Cliente> root) {
	            return criteriaBuilder.like(root.get("cpf"), "%"+ cpf + "%");
			}
		};
		return super.findByField(filtroPesquisa);
	}
}
