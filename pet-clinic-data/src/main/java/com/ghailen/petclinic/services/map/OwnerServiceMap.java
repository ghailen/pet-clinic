package com.ghailen.petclinic.services.map;

import com.ghailen.petclinic.model.Owner;
import com.ghailen.petclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }
}
