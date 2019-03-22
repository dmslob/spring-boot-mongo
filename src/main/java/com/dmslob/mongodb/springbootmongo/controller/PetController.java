package com.dmslob.mongodb.springbootmongo.controller;

import com.dmslob.mongodb.springbootmongo.model.Pet;
import com.dmslob.mongodb.springbootmongo.repo.PetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/pets")
public class PetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);

    @Autowired
    private PetRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pet> getPets() {
        LOGGER.info("getting all pets");
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pet getById(@PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") ObjectId id, @Valid
    @RequestBody Pet pets) {
        pets.setId(id);
        repository.save(pets);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pet create(@Valid @RequestBody Pet pets) {
        pets.setId(ObjectId.get());
        repository.save(pets);
        return pets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }
}
