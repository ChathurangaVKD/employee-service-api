package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.*;
import com.dasun.employeedemo.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo repo;

    private DepartmentService departmentService;

    private SalaryScaleService salaryScaleService;

    private EmployeeTypeService employeeTypeService;

    private OfficeService officeService;

    private FamilyMemberService familyMemberService;

    private AddressService addressService;


    public EmployeeServiceImpl(EmployeeRepo repo, DepartmentService departmentService, SalaryScaleService salaryScaleService, EmployeeTypeService employeeTypeService, OfficeService officeService, FamilyMemberService familyMemberService, AddressService addressService) {
        this.repo = repo;
        this.departmentService = departmentService;
        this.salaryScaleService = salaryScaleService;
        this.employeeTypeService = employeeTypeService;
        this.officeService = officeService;
        this.familyMemberService = familyMemberService;
        this.addressService = addressService;
    }


    @Override
    public Employee create(Employee employee) {

        this.persist(employee);

        return repo.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        employee = this.persist(employee);
        Employee oldEmployee = repo.findById(id).orElse(employee);

        if (employee.getAddress() != null) {
            if(employee.getAddress().getId() != null){
            Address address = addressService.update(employee.getAddress().getId(), employee.getAddress());
            employee.setAddress(address);
            }
            oldEmployee.setAddress(employee.getAddress());
        }
        if (employee.getAge() != null) {
            oldEmployee.setAge(employee.getAge());
        }
        if (employee.getDepartment() != null) {
            oldEmployee.setDepartment(employee.getDepartment());
        }
        if (employee.getEmail() != null) {
            oldEmployee.setEmail(employee.getEmail());
        }
        if (employee.getFirstName() != null) {
            oldEmployee.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName() != null) {
            oldEmployee.setLastName(employee.getLastName());
        }
        if (employee.getMobile() != null) {
            oldEmployee.setMobile(employee.getMobile());
        }
        if (employee.getSupervisor() != null) {
            oldEmployee.setSupervisor(employee.getSupervisor());
        }
        if (employee.getOffice() != null) {
            oldEmployee.setOffice(employee.getOffice());
        }
        if (employee.getType() != null) {
            oldEmployee.setType(employee.getType());
        }

        return repo.save(oldEmployee);
    }

    @Override
    public Employee get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " Employee Not Found"));

    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee addFamilyMember(Long id, FamilyMember familyMember) {
        Employee employee = this.get(id);
        List<FamilyMember> members = employee.getFamilyMembers();
        FamilyMember familyMember1 = familyMemberService.create(familyMember);
        members.add(familyMember1);
        employee.setFamilyMembers(members);
        return repo.save(employee);
    }

    @Override
    public Employee deleteFamilyMember(Long id, Long familyMemberId) {
        Employee employee = this.get(id);
        List<FamilyMember> members = employee.getFamilyMembers();
        FamilyMember familyMember1 = familyMemberService.get(familyMemberId);
        members.remove(familyMember1);
        employee.setFamilyMembers(members);
        familyMemberService.delete(familyMemberId);
        return repo.save(employee);
    }

    private Employee persist(Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department department = departmentService.get(employee.getDepartment().getId());
            employee.setDepartment(department);
        }

        if (employee.getType() != null && employee.getType().getId() != null) {
            EmployeeType employeeType = employeeTypeService.get(employee.getType().getId());
            employee.setType(employeeType);
        }

        if (employee.getOffice() != null && employee.getOffice().getId() != null) {
            Office office = officeService.get(employee.getOffice().getId());
            employee.setOffice(office);
        }

        if (employee.getSalaryScale() != null && employee.getOffice().getId() != null) {
            SalaryScale salaryScale = salaryScaleService.get(employee.getSalaryScale().getId());
            employee.setSalaryScale(salaryScale);
        }

        if (employee.getSupervisor() != null && employee.getSupervisor().getId() != null) {
            Employee supervisor = this.get(employee.getSupervisor().getId());
            employee.setSupervisor(supervisor);
        }

        return employee;
    }

}
