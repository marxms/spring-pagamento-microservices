package com.marx.instrutor.pagamento.config.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.marx.instrutor.data.Pagamento;
import com.marx.instrutor.pagamento.config.repository.util.FiltroPesquisa;

@PersistenceUnit
@Transactional
@Repository
public class PagamentoRepositoryImpl extends GenericDAO<Pagamento, Serializable> {

	protected PagamentoRepositoryImpl() {
		super(Pagamento.class);
	}

	public List<Pagamento> obterContaCorrentePorNumero(String cpf) {

		FiltroPesquisa<Pagamento> filtroPesquisa = new FiltroPesquisa<Pagamento>() {			
			@Override
	        public Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root<Pagamento> root) {
	            return criteriaBuilder.like(root.get("pagador").get("cpf"), cpf);
			}
		};
		return super.findByField(filtroPesquisa);
	}

}
