package com.marx.instrutor.cliente.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import com.marx.instrutor.cliente.repository.util.FiltroPesquisa;

import javassist.NotFoundException;

@Component
@Transactional
@NoRepositoryBean
public abstract class GenericDAO<T, I extends Serializable> {

	   @Autowired
	   protected EntityManagerFactory entityManagerFactory;

	   @Autowired
	   protected EntityManager entityManager;
	   
	   protected Class<T> persistedClass;

	   protected GenericDAO(Class<T> persistedClass) {
	       this.persistedClass = persistedClass;
	   }

	   public T save(@Valid T entity) {
	       entityManager.persist(entity);
	       entityManager.flush();
	       return entity;
	   }

	   public T update(@Valid T entity) {
	       entityManager.merge(entity);
	       entityManager.flush();
	       return entity;
	   }

	   public void remove(I id) throws NotFoundException {
	       T entity = findById(id);
	       if(entity == null) {
	    	   throw new NotFoundException("Cliente não existe");
	       }
	       entityManager.remove(entity);
	       entityManager.flush();
	   }

	   public List<T> getList() {
		   CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	       CriteriaQuery<T> query = builder.createQuery(persistedClass);
	       query.from(persistedClass);
	       return entityManager.createQuery(query).getResultList();
	   }

	   public T findById(I id) {
	       T retorno = entityManager.find(persistedClass, id);
		   return retorno;
	   }
	   
	   public List<T> findByField(FiltroPesquisa<T> filtroPesquisa) {
		    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		    CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(persistedClass);
		    Root<T> entityRoot = criteriaQuery.from(persistedClass);
		    criteriaQuery.select(entityRoot);
		    criteriaQuery.where(filtroPesquisa.buildPredicate(criteriaBuilder, entityRoot));
		    TypedQuery<T> query = entityManager
		            .createQuery(criteriaQuery);
		    return query.getResultList();
		}
	   
}
