package com.betaplan.angela.nftart.services;


import com.betaplan.angela.nftart.models.Designer;
import com.betaplan.angela.nftart.repositories.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignerService {
    @Autowired
    private DesignerRepository designerRepository;

    public List<Designer> getAll(){
        return designerRepository.findAll();
    }

    public Designer getById(Long id){
        return designerRepository.findById(id).orElse(null);
    }
}
