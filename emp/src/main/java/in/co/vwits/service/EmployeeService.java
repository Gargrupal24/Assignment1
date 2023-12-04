package in.co.vwits.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.sms.model.Employee;

public interface EmployeeService {

	

	List<Employee> findAll();

	void save(Employee e);

	//Find
	Optional<Employee> findById(int id) throws EmployeeNotFoundException;

	void deleteById(int id);

	void updateById(int id, double modifiedSalary);

	
}