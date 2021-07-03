package br.com.alucar.services;

import br.com.alucar.domain.entities.BaseEntity;

import java.util.List;

public interface BaseService<Entity extends BaseEntity> {

    List<Entity> findAll();

    Entity findById(Long id);

    void delete(Long id);

    void logicalDelete(Long id);

    Entity save(Entity entity);

    Entity update(Entity entity, Long id);
}
