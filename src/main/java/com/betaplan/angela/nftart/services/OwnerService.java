package com.betaplan.angela.nftart.services;


import com.betaplan.angela.nftart.models.Owner;
import com.betaplan.angela.nftart.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAll(){
        return ownerRepository.findAll();
    }
}
