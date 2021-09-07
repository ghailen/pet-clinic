package com.ghailen.petclinic.services.map;

import com.ghailen.petclinic.model.Owner;
import com.ghailen.petclinic.model.Visit;
import com.ghailen.petclinic.services.OwnerService;
import com.ghailen.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
}
