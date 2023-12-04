package in.co.vwits.sms.dao.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.sms.model.Employee;
// This class is responsible for talking to(Read,Insert, Update, Delete ) 
// underline data store (in memory/database).

public class EmployeeDaoImpl {
	
	private List<Employee> employees;
	
	public EmployeeDaoImpl() {
		employees = new ArrayList<Employee>();
		Employee e1= new Employee();
		e1.setId(1);
		e1.setName("Anamika");
		e1.setSalary(9900);
		
		
		Employee e2= new Employee();
		e2.setId(2);
		e2.setName("Misha");
		e2.setSalary(8900);
		
		Employee e3= new Employee();
		e2.setId(3);
		e2.setName("Nisha");
		e2.setSalary(8000);
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
	}
	public List<Employee> findAll(){
		return employees;
	}
	public void save(Employee e) {
		employees.add(e);
	}
	
	public Optional<Employee> findById(int id) {
		for(Employee e:employees) {
			if(e.getId()==id) {
				return Optional.of(e);				
			}
		}
		return Optional.empty();
		
		
	}
	public void deleteById(int id) {
		
		Iterator<Employee>i= employees.iterator();
		while(i.hasNext()) {
			Employee e= i.next();
			if(e.getId()==id) {
				i.remove();
			}
		}
		
	}
    public void updateById(int id, double modifiedSalary) {
		for(Employee e:employees) {
			if(e.getId()==id) {
				e.setSalary(modifiedSalary);
			}
		}
		
	}
    
   

}

