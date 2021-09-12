package com.ghailen.petclinic.controllers;

import com.ghailen.petclinic.model.Owner;
import com.ghailen.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owner/createOrUpdateOwnerForm";

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // don t want to allow the web forms to address and manipulate the ID property
    @InitBinder
    public void setAllowerField(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("owner", new Owner());
        return "owner/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {

        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owner/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owner/ownersList";
        }
    }

  /*  @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }*/

    @RequestMapping("/find")
    public String findOwners() {
        return "noimplemented";
    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owner/ownerDetails");
        mav.addObject((ownerService.findById(ownerId)));
        return mav;
    }


    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerService.findById(ownerId);
        model.addAttribute(owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(Owner owner, BindingResult result,
                                         @PathVariable Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            ownerService.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }


}
