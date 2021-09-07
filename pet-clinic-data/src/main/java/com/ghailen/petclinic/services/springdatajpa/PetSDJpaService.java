package com.ghailen.petclinic.services.springdatajpa;

import com.ghailen.petclinic.model.Pet;
import com.ghailen.petclinic.repositories.PetRepository;
import com.ghailen.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;
import java.util.Set;
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

   private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
