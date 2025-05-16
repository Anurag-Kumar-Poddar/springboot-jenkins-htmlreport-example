package com.Anurag.springboot_jenkins_htmlreport_example;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	List<Employee> findById(int id);
	List<Employee> findByName(String name);
	List<Employee> findByCountry(String country);
	List<Employee> findByPincode(int pincode);
}