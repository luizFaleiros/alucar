package br.com.alucar.services;

import br.com.alucar.domain.entities.Automovel;
import br.com.alucar.exceptions.AutomovelNotFoundException;
import br.com.alucar.repositories.AutomoveisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements BaseService<Automovel> {

    private final AutomoveisRepository automoveisRepository;

    @Override
    public List<Automovel> findAll() {
        return automoveisRepository.findAll();
    }

    @Override
    public Automovel findById(Long id) {
        return automoveisRepository.findById(id).orElseThrow(() -> new AutomovelNotFoundException());
    }

    @Override
    public void delete(Long id) {
        Automovel automovel = findById(id);
        automoveisRepository.delete(automovel);
    }

    @Override
    public void logicalDelete(Long id) {
        Automovel automovel = findById(id);
        automovel.setIsDeleted(true);
        save(automovel);
    }

    @Override
    public void save(Automovel automovel) {
        automoveisRepository.save(automovel);
    }

    @Override
    public Automovel update(Automovel entity, Long id) {
        Automovel bdEntity = findById(id);
        bdEntity.setModelo(entity.getModelo());
        bdEntity.setNome(entity.getNome());
        bdEntity.setAno(entity.getAno());
        bdEntity.setType(entity.getType());
        bdEntity.setSeatsQuantity(entity.getSeatsQuantity());
        bdEntity.setPortQuantity(entity.getPortQuantity());
        bdEntity.setColor(entity.getColor());
        bdEntity.setCambio(entity.getCambio());
        return automoveisRepository.save(bdEntity);
    }

}
