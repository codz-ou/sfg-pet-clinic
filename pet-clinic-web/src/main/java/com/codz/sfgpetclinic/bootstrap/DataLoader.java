package com.codz.sfgpetclinic.bootstrap;

import com.codz.sfgpetclinic.model.Owner;
import com.codz.sfgpetclinic.model.Pet;
import com.codz.sfgpetclinic.model.PetType;
import com.codz.sfgpetclinic.model.Vet;
import com.codz.sfgpetclinic.services.OwnerService;
import com.codz.sfgpetclinic.services.PetTypeService;
import com.codz.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Jordan");
        owner1.setAddress("E. Vilde Tee 121");
        owner1.setCity("Tallinn");
        owner1.setTelephone("57894466");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glendovine");
        owner1.setAddress("Parnu strt 255");
        owner1.setCity("Parnu");
        owner1.setTelephone("784513644");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);


        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axei");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
