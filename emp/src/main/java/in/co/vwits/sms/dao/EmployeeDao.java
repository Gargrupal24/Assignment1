package in.co.vwits.sms.dao;

import java.util.List;
import java.util.Optional;

import in.co.vwits.sms.model.Employee;

public interface EmployeeDao {
	

	public int save(Employee s);
	public void deleteById(int id);
	public Optional<Employee> findById(int id);
	public List<Employee> findAll();
	 public void updateById(int id, double modifiedSalary);


}
