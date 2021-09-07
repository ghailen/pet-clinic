package com.ghailen.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet extends BaseEntity {
    @Column(name="name")
    private String name;


    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visitSet = new HashSet<>();

    public Set<Visit> getVisitSet() {
        return visitSet;
    }

    public void setVisitSet(Set<Visit> visitSet) {
        this.visitSet = visitSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
