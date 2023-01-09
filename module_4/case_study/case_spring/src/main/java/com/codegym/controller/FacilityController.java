package com.codegym.controller;

import com.codegym.model.dto.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

//    @GetMapping("/listFacility")
//    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model, @RequestParam(name = "name", defaultValue = "") String name,
//                           @RequestParam(name = "facilityId", defaultValue = "") String facilityType) {
//        Page<Facility> facilityPage = facilityService.listAndSearch(pageable, name, facilityType);
//        model.addAttribute("facilityPage", facilityPage);
//        List<FacilityType> facilityTypeList = facilityTypeService.showList();
//        model.addAttribute("facilityTypeList", facilityTypeList);
//        List<RentType> rentTypeList = rentTypeService.showList();
//        model.addAttribute("rentTypeList", rentTypeList);
//        model.addAttribute("facility", new Facility());
//        return "/views/facility/list";
//    }

    @GetMapping("/listFacility")
    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model, @RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "facilityType", defaultValue = "0") int facilityType) {

        Page<Facility> facilityPage;
        if (facilityType == 0) {
            facilityPage = facilityService.listAndSearchNoId(pageable, name);
        } else {
            facilityPage = facilityService.listAndSearch(pageable, name, facilityType);
        }
        model.addAttribute("facilityPage", facilityPage);
        List<FacilityType> facilityTypeList = facilityTypeService.showList();
        model.addAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.showList();
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facility", new Facility());
        return "views/facility/list";
    }

    @GetMapping("/showCreateFacility")
    public String showCreateFacility(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        List<FacilityType> facilityTypeList = facilityTypeService.showList();
        model.addAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.showList();
        model.addAttribute("rentTypeList", rentTypeList);
        return "/views/facility/create";
    }

    @PostMapping("/creatFacility")
    public String createFacility(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            List<FacilityType> facilityTypeList = facilityTypeService.showList();
            model.addAttribute("facilityTypeList", facilityTypeList);
            List<RentType> rentTypeList = rentTypeService.showList();
            model.addAttribute("rentTypeList", rentTypeList);
            return "/views/facility/create";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        boolean check = facilityService.save(facility);
        String mess = "Thêm mới thành công";
        if (!check) {
            mess = "Tên hợp đồng đã tồn tại,Thêm mới thất bại";
            redirectAttributes.addFlashAttribute("mess", mess);
            return "/views/facility/create";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/facility/listFacility";
    }


    @GetMapping("/showUpdateFacility/{id}")
    public String showUpdate(Model model, @PathVariable("id") int id) {
        Optional<Facility> facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility.get(), facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        List<FacilityType> facilityTypeList = facilityTypeService.showList();
        model.addAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.showList();
        model.addAttribute("rentTypeList", rentTypeList);
        return "/views/facility/update";
    }

    @PostMapping("/updateFacility")
    public String update(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            List<FacilityType> facilityTypeList = facilityTypeService.showList();
            model.addAttribute("facilityTypeList", facilityTypeList);
            List<RentType> rentTypeList = rentTypeService.showList();
            model.addAttribute("rentTypeList", rentTypeList);
            return "/views/facility/update";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        boolean check = facilityService.save(facility);
        String mess = "Chỉnh sửa thành công";
        if (!check) {
            mess = "Chỉnh sửa thất bại,thông tin đã có trong hệ thống";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/facility/listFacility";
    }


    @PostMapping("/deleteFacility")
    public String delete(@RequestParam("idDelete") int id) {
        facilityService.deleteById(id);
        return "redirect:/facility/listFacility";
    }

}
