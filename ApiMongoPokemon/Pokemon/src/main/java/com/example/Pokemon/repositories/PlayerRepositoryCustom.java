package com.example.Pokemon.repositories;

import com.example.Pokemon.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepositoryCustom implements CustomPlayerRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Player findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Player.class);
    }

    @Override
    public List<Player> findPlayersByNivelGreaterThan(int nivel) {
        Query query = new Query(Criteria.where("nivel").gt(nivel));
        return mongoTemplate.find(query, Player.class);
    }
}
