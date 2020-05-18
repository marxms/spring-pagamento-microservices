package com.marx.instrutor.contacorrente.repository;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.marx.instrutor.contacorrente.repository.util.FiltroPesquisa;
import com.marx.instrutor.data.ContaCorrente;

@PersistenceUnit
@Transactional
@Repository
public class ContaCorrenteRepositoryImpl extends GenericDAO<ContaCorrente, Serializable> {

	protected ContaCorrenteRepositoryImpl() {
		super(ContaCorrente.class);
	}

	public ContaCorrente obterContaCorrentePorNumero(String numeroContaCorrente) {

		FiltroPesquisa<ContaCorrente> filtroPesquisa = new FiltroPesquisa<ContaCorrente>() {			
			@Override
	        public Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root<ContaCorrente> root) {
	            return criteriaBuilder.like(root.get("numeroConta"), "%"+ numeroContaCorrente + "%");
			}
		};
		return Objects.requireNonNull(super.findByField(filtroPesquisa).get(0));
	}

	@Override
	public ContaCorrente update(@Valid ContaCorrente entity) {
		super.entityManager.detach(entity.getTitular());
		return super.update(entity);
	}

}
