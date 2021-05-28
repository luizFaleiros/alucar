package br.com.alucar.repositories.specification;


import br.com.alucar.domain.entities.RentCar;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RentCarSpecification implements Specification<RentCar> {


    @Override
    public Predicate toPredicate(Root<RentCar> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.and();

        return predicate;
    }

    public void add(Predicate predicate, Expression expression) {
        predicate.getExpressions().add(expression);
    }

}
