package com.example.Pokemon.repositories;


import com.example.Pokemon.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PokemonRepositoryCustom implements CustomPokemonRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Pokemon findById(String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Pokemon.class);
    }

    @Override
    public ArrayList<Pokemon> findPokemonByGreaterThan(double duration) {

        Query query = new Query(Criteria.where("duracion").gt(duration));


        return (ArrayList<Pokemon>) mongoTemplate.find(query,Pokemon.class);
    }




}
