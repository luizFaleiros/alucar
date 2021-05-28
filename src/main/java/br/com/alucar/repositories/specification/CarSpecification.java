package br.com.alucar.repositories.specification;

import br.com.alucar.domain.dto.filters.CarFilter;
import br.com.alucar.domain.entities.Car;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

@RequiredArgsConstructor
public class CarSpecification implements Specification<Car> {

    private final CarFilter carFilter;

    public Specification<Car> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.and();
        Optional.ofNullable(carFilter.getColor())
                .ifPresent(color -> add(predicate, criteriaBuilder.equal(root.get("color"), color)));
        Optional.ofNullable(carFilter.getShift())
                .ifPresent(shift -> add(predicate, criteriaBuilder.equal(root.get("shift"), shift)));
        Optional.ofNullable(carFilter.getYear())
                .ifPresent(year -> add(predicate, criteriaBuilder.equal(root.get("year"), year)));
        Optional.ofNullable(carFilter.getName())
                .ifPresent(name -> add(predicate, criteriaBuilder.like(root.get("name"), (new StringBuilder()
                        .append("%")
                        .append(name)
                        .append("%"))
                        .toString())));
        Optional.ofNullable(carFilter.getType())
                .ifPresent(type -> add(predicate, criteriaBuilder.equal(root.get("type"), type)));

        Optional.ofNullable(carFilter.getSeatsQuantity())
                .ifPresent(seats -> add(predicate, criteriaBuilder.equal(root.get("seatsQuantity"), seats)));

        Optional.ofNullable(carFilter.getPortQuantity())
                .ifPresent(ports -> add(predicate, criteriaBuilder.equal(root.get("portQuantity"), ports)));
        return predicate;
    }

    public void add(Predicate predicate, Expression expression) {
        predicate.getExpressions().add(expression);
    }

}
