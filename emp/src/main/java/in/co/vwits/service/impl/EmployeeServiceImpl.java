
package in.co.vwits.service.impl;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.service.EmployeeService;
import in.co.vwits.sms.dao.EmployeeDao;
import in.co.vwits.sms.dao.impl.EmployeeDaoImpl;
import in.co.vwits.sms.dao.impl.EmployeeJDBCDaoImpl;
import in.co.vwits.sms.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	/*using reference of interface to communicate with other layer of application is known as
	 * coding to interface. It is the best practice as it give loose coupling among layers 
	 */
	private EmployeeDao dao;
	public EmployeeServiceImpl(){
		dao= new EmployeeJDBCDaoImpl();
		
	}
	
	@Override
	public List<Employee> findAll(){
		return dao.findAll();
	}
	@Override
	public void save(Employee s) {
		dao.save(s);
	}
	
	//Find
		public Optional<Employee> findById(int id) throws EmployeeNotFoundException {
			Optional<Employee> p=dao.findById(id);
			if(p.isPresent()) {
				return p;
			}
			else {
				// throw user defined exception "StudentNotFound"
				throw new EmployeeNotFoundException();
			}

		}
	public void deleteById(int id) {
		
		dao.deleteById(id);
		
	}

	@Override
	public void updateById(int id, double modifiedSalary) {
		// TODO Auto-generated method stub
		
	}
    

	
    
	
}
