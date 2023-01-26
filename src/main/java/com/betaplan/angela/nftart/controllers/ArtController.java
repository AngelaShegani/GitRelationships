package com.betaplan.angela.nftart.controllers;


import com.betaplan.angela.nftart.models.Art;
import com.betaplan.angela.nftart.models.Designer;
import com.betaplan.angela.nftart.services.ArtService;
import com.betaplan.angela.nftart.services.DesignerService;
import com.betaplan.angela.nftart.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class ArtController {

    @Autowired
    private ArtService artService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private DesignerService designerService;

    @RequestMapping("/")
    public String index(Model artModel){
        List<Art> arts = artService.getAllArts();
        artModel.addAttribute("allArts", arts);
        return "index";
    }

    @GetMapping("/new")
    public  String newArt(@ModelAttribute("newArt") Art newArt,Model model ){
        model.addAttribute("allOwners", ownerService.getAll());
        return "newArt";
    }

    @PostMapping("/create")
    public String creatArt(@Valid @ModelAttribute("newArt")Art newArt, @NotNull BindingResult results){
        if(results.hasErrors()){
            return "newArt";
        }
        artService.creatArt(newArt);
        return "redirect:/";
    }

    @GetMapping("/artDetail/{id}")
    public String artDetails(@PathVariable Long id,Model model){
        Art art= artService.artDetails(id);
        model.addAttribute("art", art);
        model.addAttribute("allDesigners", designerService.getAll());
        return "details";
    }

    @GetMapping("/edit/{id}")
    public String editArt(@PathVariable Long id, Model model){
        Art editArt = artService.artDetails(id);
        model.addAttribute("editArt", editArt);
        return "edit";
    }
    @PutMapping("/update/{id}")
    public String updateArt(@PathVariable Long id,@Valid @ModelAttribute("editArt") Art editArt,@NotNull BindingResult results){
        if(results.hasErrors()){
            return "edit";
        }
        artService.updateArt(editArt);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArt(@PathVariable Long id){
        artService.deleteArt(id);
        return "redirect:/";
    }

    @PostMapping("/assign/{id}")
    public String assign(@PathVariable Long id, @RequestParam Long designerId){
        Art art= artService.artDetails(id);
        Designer designer = designerService.getById(id);
        artService.assignDesigner(art, designer);
        return "redirect:/artDetail/" + id;
    }


}
