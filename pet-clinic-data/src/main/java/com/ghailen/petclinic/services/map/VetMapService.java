package com.ghailen.petclinic.services.map;

import com.ghailen.petclinic.model.Speciality;
import com.ghailen.petclinic.model.Vet;
import com.ghailen.petclinic.services.SpecialityService;
import com.ghailen.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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

        if (object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                Speciality savedSpeciality =  specialityService.save(speciality);
                speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save( object);
    }
}
