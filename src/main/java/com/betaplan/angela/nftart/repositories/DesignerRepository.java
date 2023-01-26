package com.betaplan.angela.nftart.repositories;


import com.betaplan.angela.nftart.models.Designer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignerRepository extends CrudRepository<Designer, Long> {

    List<Designer> findAll();
}
