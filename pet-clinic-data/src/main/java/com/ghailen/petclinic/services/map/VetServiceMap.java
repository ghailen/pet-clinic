package com.ghailen.petclinic.services.map;

import com.ghailen.petclinic.model.Vet;
import com.ghailen.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public Vet save(Vet object) {
        return super.save( object);
    }
}
