package com.codegym.controller.rest;


import com.codegym.model.contract.AttachFacility;
import com.codegym.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attach")
public class RestContractController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/showAttch/{id}")
    public ResponseEntity<List<AttachFacility>> showList(@PathVariable("id") int id, Model model) {
        List<AttachFacility> attachFacilities = attachFacilityService.findByList(id);
        model.addAttribute("attachFacilities", attachFacilities);
        if (attachFacilities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilities, HttpStatus.OK);
    }
}
