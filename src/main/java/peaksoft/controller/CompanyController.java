package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Company;
import peaksoft.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }



    @GetMapping("/companies")
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/saveCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/companies/companies";
    }

    @GetMapping("/update/{id}")
    public String updateCompany(@PathVariable("id") Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("updateCompany", company);
        return "company/updateCompany";
    }

    @PatchMapping("/{id}")
    public String saveCompanyUpdate(@PathVariable("id") Long id, @ModelAttribute("company") Company company) {
       companyService.updateCompany(id, company);
        return "redirect:/companies/companies";
    }

    @DeleteMapping("/delete")
    public String deleteCompany(@RequestParam("id") Long id) {
        Company company = companyService.getCompanyById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies/companies";
    }
}
