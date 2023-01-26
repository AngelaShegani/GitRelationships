package com.betaplan.angela.nftart.services;


import com.betaplan.angela.nftart.models.Art;
import com.betaplan.angela.nftart.models.Designer;
import com.betaplan.angela.nftart.repositories.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtService {

    @Autowired
    private ArtRepository artRepo;

    //create

    //update
    //delete
    //find all arts

    public List<Art> getAllArts(){
        //Bussines Locig
        return artRepo.findAll();
    }

    //create a new art

    public void creatArt(Art art){
        artRepo.save(art);
    }

    //get art details(get by id)
    public Art artDetails(Long id){
        return artRepo.findById(id).orElse(null);
    }

    public void updateArt(Art art){
        artRepo.save(art);
    }

    public void deleteArt(Long id){
        artRepo.deleteById(id);
    }

    public void assignDesigner(Art art, Designer designer){
        List<Designer> designers=art.getDesigners();
        designers.add(designer);
        artRepo.save(art);
    }

}
