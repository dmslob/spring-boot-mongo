package com.dmslob.mongodb.springbootmongo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Pet {

    @Id
    public ObjectId _id;

    private String name;
    private String species;
    private String breed;

    public Pet() {
    }

    public Pet(ObjectId _id, String name, String species, String breed) {
        this._id = _id;
        this.name = name;
        this.species = species;
        this.breed = breed;
    }

    // ObjectId needs to be converted to string
    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
