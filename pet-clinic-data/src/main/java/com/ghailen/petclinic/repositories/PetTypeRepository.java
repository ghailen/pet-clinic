package com.ghailen.petclinic.repositories;

import com.ghailen.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository  extends CrudRepository<PetType,Long> {
}
