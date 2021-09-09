package com.ghailen.petclinic.services.springdatajpa;

import com.ghailen.petclinic.model.Owner;
import com.ghailen.petclinic.repositories.OwnerRepository;
import com.ghailen.petclinic.repositories.PetRepository;
import com.ghailen.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner= new Owner();

    @BeforeEach
    void setUp() {
        returnOwner.setId(1L);
        returnOwner.setLastName(LAST_NAME);

    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        returnOwnersSet.add(owner);
        returnOwnersSet.add(owner2);
        Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findByIdNotFound() {

        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }


    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);
        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(returnOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        Mockito.verify(ownerRepository).save(Mockito.any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        Mockito.verify(ownerRepository).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());
    }

    @Test
    void findByLastName() {

        Mockito.when(service.findByLastName(Mockito.any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
        Mockito.verify(ownerRepository).findByLastName(Mockito.any());

    }
}