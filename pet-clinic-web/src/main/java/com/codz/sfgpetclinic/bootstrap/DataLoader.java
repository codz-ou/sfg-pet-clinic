package com.codz.sfgpetclinic.bootstrap;

import com.codz.sfgpetclinic.model.Owner;
import com.codz.sfgpetclinic.model.Vet;
import com.codz.sfgpetclinic.services.OwnerService;
import com.codz.sfgpetclinic.services.VetService;
import com.codz.sfgpetclinic.services.map.OwnerServiceMap;
import com.codz.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Micheal");
        owner1.setLastName("Jordan");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glendovine");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axei");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}