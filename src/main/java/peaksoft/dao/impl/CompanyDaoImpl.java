package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CompanyDao;
import peaksoft.entities.Company;
import peaksoft.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = entityManager.createQuery("from Company ",Company.class).getResultList();
        return companies;
    }

    @Override
    public Company getCompanyById(Long companyId) {
        Company company = entityManager.find(Company.class,companyId);
        return company;
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public void updateCompany(Long companyId, Company company) {
       Company company1 = getCompanyById(companyId);
       company1.setCompanyName(company.getCompanyName());
       company1.setLocatedCountry(company.getLocatedCountry());
       entityManager.merge(company1);
    }

    @Override
    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company)? company:entityManager.merge(company));
    }
}
