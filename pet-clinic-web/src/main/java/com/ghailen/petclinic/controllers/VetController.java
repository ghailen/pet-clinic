package com.ghailen.petclinic.controllers;

import com.ghailen.petclinic.model.Vet;
import com.ghailen.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vet/index";
    }

    // response body json
    @GetMapping("/api/vets")
    public @ResponseBody
    Set<Vet> getVetsJson() {
        return vetService.findAll();

    }


}
