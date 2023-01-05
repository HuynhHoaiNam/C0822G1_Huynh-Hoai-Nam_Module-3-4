package com.codegym.controller;


import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.emoloyee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        List<Contract> contractPage = contractService.listContract();
        model.addAttribute("contractPage", contractPage);
        List<Customer> customerList = customerService.findAll2();
        model.addAttribute("customerList", customerList);
        List<Facility> facilityList = facilityService.findAll();
        model.addAttribute("facilityList", facilityList);
        List<ContractDetail> contractDetailList = contractDetailService.listContractDetail();
        model.addAttribute("contractDetailList", contractDetailList);
        List<AttachFacility> attachFacilityList = attachFacilityService.listAtFac();
        model.addAttribute("attachFacilityList", attachFacilityList);
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "/views/contract/list";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        return "redirect:/contract/list";
    }

    @PostMapping("/createContractDetail")
    public String create(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }

    @GetMapping("/showAttch/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        List<AttachFacility> attachFacilities = attachFacilityService.findByList(id);
        model.addAttribute("attachFacilities", attachFacilities);
        return "/views/contract/list";
    }

}