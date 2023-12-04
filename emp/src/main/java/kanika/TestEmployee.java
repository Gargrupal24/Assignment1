package kanika;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.service.EmployeeService;
import in.co.vwits.service.impl.EmployeeServiceImpl;
import in.co.vwits.sms.model.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		int option=1;
		Scanner sc = null;
		try {
			sc= new Scanner(System.in);
	       
		
	
			EmployeeServiceImpl service = new EmployeeServiceImpl();
		
				
		//Show all students
		
		do {
			System.out.println("Welcome to student mangement ");
			System.out.println("1 Find all records");
			System.out.println("2 Insert Records");
			System.out.println("3 Find student by ID.");
			System.out.println("4 Delete student by ID.");
			System.out.println("5 Update student by ID.");
			System.out.println("-1 to Exit");
			System.out.println("Enter choice");
			
			option= sc.nextInt();
			
			switch(option) {
			case 1:
				List<Employee> employees = service.findAll();
			    System.out.println(employees);
			    break;
			case 2:
				//
				Employee e= new Employee();
				e.setName("Ram");
				e.setId(23);
				e.setSalary(98);
				service.save(e);
				break;
			case 3:
				System.out.println("Enter the id.");
				int id=sc.nextInt();
				Optional<Employee> foundEmployee;
				
				try {
					
					foundEmployee = service.findById(id);
					System.out.println("Found Employee"+foundEmployee.get());
				} catch (EmployeeNotFoundException e1) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Employee Not Found");
				}
				
				break;
			case 4:
				System.out.println("Enter the id.");
				try {
					id=sc.nextInt();
					service.deleteById(id);
				}
				catch(InputMismatchException e1) {
					System.out.println("ID must be an Integer value");
					sc.nextLine(); //This statement is used to discard the input.
					
					
				}
				
				
				break;
			
			case 5:
				double modifiedSalary;
				System.out.println("Enter the id.");
			    id=sc.nextInt();
				System.out.println("Enter new salary");
				modifiedSalary=sc.nextDouble();
				service.updateById(id,modifiedSalary);
				break;
			
				
			case -1:
				System.out.println("Thank You");
				break;
				
			}
			
		}while(option!=-1);

	}
	finally {
		sc.close();
	}
	}
}
