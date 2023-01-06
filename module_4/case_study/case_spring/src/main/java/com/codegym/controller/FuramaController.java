package com.codegym.controller;


import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.dto.CustomerDto;
import com.codegym.model.dto.CustomerDtod;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
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
public class FuramaController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;


    @RequestMapping("/")
    public String showHome() {
        return "/views/home";
    }

    @GetMapping("/listCustomer")
    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable,
                               @RequestParam(name = "name", defaultValue = "") String name,
                               @RequestParam(name = "address", defaultValue = "") String address,
                               @RequestParam(name = "email", defaultValue = "") String email) {
        Page<Customer> customerPage = customerService.findAll(name, address, email, pageable);
        model.addAttribute("customerPage", customerPage);
        return "/views/customer/list";
    }

    @GetMapping("/showCreateCustomer")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        List<CustomerType> customerTypeList = customerTypeService.showList();
        model.addAttribute("customerTypeList", customerTypeList);
        return "/views/customer/create";
    }

    @PostMapping("/createCustomer")
    public String create(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.showList();
            model.addAttribute("customerTypeList", customerTypeList);
            redirectAttributes.addFlashAttribute("mess", "Thêm mới thất bại");
            return "/views/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/listCustomer";
    }


    @GetMapping("/showUpdateCustomer/{id}")
    public String showUpdateCustomer(Model model, @PathVariable("id") int id) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerTypeService.showList();
        model.addAttribute("customerTypeList", customerTypeList);
        return "/views/customer/update";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.update(customer);
        return "redirect:/listCustomer";
    }


    @PostMapping("/deleteCustomer")
    public String deleteCutomer(@RequestParam("idDelete") int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/listCustomer";
    }

}
