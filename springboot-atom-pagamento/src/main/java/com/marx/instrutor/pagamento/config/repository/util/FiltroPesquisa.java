package com.marx.instrutor.pagamento.config.repository.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class FiltroPesquisa<T> {
    public abstract Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root<T> root);

}
