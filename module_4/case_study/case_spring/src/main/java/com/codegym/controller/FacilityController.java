package com.codegym.controller;

import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/listFacility")
    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model, @RequestParam(name = "name", defaultValue = "") String name,
                           @RequestParam(name = "facilityId", defaultValue = "") String facilityId) {
        Page<Facility> facilityPage = facilityService.listAndSearch(pageable, name, facilityId);
        model.addAttribute("facilityPage", facilityPage);
        List<FacilityType> facilityTypeList = facilityTypeService.showList();
        model.addAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.showList();
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facility", new Facility());
        return "/views/facility/list";
    }

    @GetMapping("/showCreateFacility")
    public String showCreateFacility(Model model) {
        model.addAttribute("facility", new Facility());
        List<FacilityType> facilityTypeList = facilityTypeService.showList();
        model.addAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.showList();
        model.addAttribute("rentTypeList", rentTypeList);
        return "/views/facility/create";
    }

    @PostMapping("/creatFacility")
    public String createFacility(@ModelAttribute("facility") Facility facility) {
        facilityService.save(facility);
        return "redirect:/showCreateFacility";
    }


    @GetMapping("/showUpdateFacility/{id}")
    public String showUpdate(Model model, @PathVariable("id") int id) {
        Optional<Facility> facility = facilityService.findById(id);
        model.addAttribute("facility", facility);
        List<FacilityType> facilityTypeList = facilityTypeService.showList();
        model.addAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.showList();
        model.addAttribute("rentTypeList", rentTypeList);
        return "/views/facility/update";
    }

    @PostMapping("/updateFacility")
    public String update(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.update(facility);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/listFacility";
    }

    @PostMapping("/deleteFacility")
    public String delete(@RequestParam("idDelete") int id) {
        facilityService.deleteById(id);
        return "redirect:/facility/listFacility";
    }


}
