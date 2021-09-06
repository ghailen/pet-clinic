package com.ghailen.petclinic.services;

import com.ghailen.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
