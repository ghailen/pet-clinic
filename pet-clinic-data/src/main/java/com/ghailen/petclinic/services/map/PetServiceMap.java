package com.ghailen.petclinic.services.map;

import com.ghailen.petclinic.model.Pet;
import com.ghailen.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }
}
