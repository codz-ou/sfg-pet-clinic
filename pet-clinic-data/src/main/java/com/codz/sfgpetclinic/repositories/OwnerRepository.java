package com.codz.sfgpetclinic.repositories;

import com.codz.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findOwnerByLastName(String lastName);
}
