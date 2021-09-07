package com.ghailen.petclinic.services.springdatajpa;

import com.ghailen.petclinic.model.Owner;
import com.ghailen.petclinic.repositories.OwnerRepository;
import com.ghailen.petclinic.repositories.PetRepository;
import com.ghailen.petclinic.repositories.PetTypeRepository;
import com.ghailen.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        /* Optional<Owner> optionalOwner = ownerRepository.findById(id);
       if (optionalOwner.isPresent()) {
            return optionalOwner.get();
        }
        else
        return null;*/
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        System.out.println("#######################################");
        System.out.println("#######################################");
        System.out.println("#######################################");
        System.out.println("#######################################");
        System.out.println("#######################################");
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
