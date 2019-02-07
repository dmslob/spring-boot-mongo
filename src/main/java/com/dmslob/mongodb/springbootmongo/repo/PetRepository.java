package com.dmslob.mongodb.springbootmongo.repo;

import com.dmslob.mongodb.springbootmongo.model.Pet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {

    Pet findById(ObjectId _id);
}
