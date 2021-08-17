package com.ghailen.petclinic.services;

import com.ghailen.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
