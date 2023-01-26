package com.betaplan.angela.nftart.repositories;

import com.betaplan.angela.nftart.models.Art;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtRepository extends CrudRepository<Art,Long> {

    List<Art> findAll();
}
