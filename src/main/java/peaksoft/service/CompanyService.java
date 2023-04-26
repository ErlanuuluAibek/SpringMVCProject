package peaksoft.service;

import peaksoft.entities.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    Company getCompanyById(Long companyId);
    void addCompany(Company company);
    void updateCompany(Long companyId,Company company);
    void deleteCompany(Company company);
}
