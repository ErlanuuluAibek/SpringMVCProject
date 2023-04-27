package peaksoft.dao;

import peaksoft.entities.Company;
import peaksoft.entities.Student;

import java.util.List;

public interface CompanyDao {
    List<Company> getAllCompanies();
    Company getCompanyById(Long companyId);
    void addCompany(Company company);
    void updateCompany(Long Id,Company company);
    void deleteCompany(Company company);
}
