package in.co.vwits.sms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import in.co.vwits.sms.dao.EmployeeDao;
import in.co.vwits.sms.model.Employee;

public class EmployeeJDBCDaoImpl implements EmployeeDao {
	//SAVE
	public int save(Employee e) {
		Connection con=null;
		PreparedStatement pstmt= null;
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table_employee", "root","root");
			
			
           pstmt = con.prepareStatement("INSERT INTO emp VALUES(?,?,?,?,?)");
           //4 ? are map columns in the table
           
           /*
            * Before actually firing the query we must set the values for all the ? marks.
            */
           pstmt.setInt(1, e.getId());
           pstmt.setString(2, e.getName());
           pstmt.setDouble(3,e.getSalary());
          
           
          
           int noOfRowSpaceUpdated = pstmt.executeUpdate();
           // firing query...
          // System.out.println("No of records updated are"+ noOfRowSpaceUpdated);
           return noOfRowSpaceUpdated;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;

	}
	// DELETE
public void deleteById(int id) {
	
		Connection con=null;
		PreparedStatement pstmt= null;
		

		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table_employee", "root","root");
			
			
            pstmt = con.prepareStatement("DELETE FROM emp WHERE id=?");
            //4 ? are map columns in the table 
            /*
             * Before actually firing the querry we must set the values for all the ? marks.
             */
            pstmt.setInt(1, id);
            int noOfRowSpaceUpdated = pstmt.executeUpdate();// firing querry...
           // System.out.println("No of records updated are"+ noOfRowSpaceUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

		

//FIND
public Optional<Employee> findById(int id) {
	Connection con=null;
	PreparedStatement pstmt= null;
	

	try {
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table_employee", "root","root");
		
		
        pstmt = con.prepareStatement("SELECT* FROM emp WHERE id=?");
        //4 ? are map columns in the table 
        /*
         * Before actually firing the query we must set the values for all the ? marks.
         */
        Employee foundEmployee = new Employee();
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
        	foundEmployee.setId(rs.getInt(1));
        	foundEmployee.setName(rs.getString(2));
        	foundEmployee.setSalary(rs.getDouble(3));
        	
        }
        return Optional.of(foundEmployee);
       
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			pstmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return Optional.empty();
			}
//FINDALL
public List<Employee> findAll() {
	List<Employee> employees = new ArrayList<>();
	
		Connection con=null;
		PreparedStatement pstmt= null;
		

		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table_employee", "root","root");
             pstmt = con.prepareStatement("SELECT* FROM emp ");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	Employee foundEmployee = new Employee();
            	foundEmployee.setId(rs.getInt(1));
            	foundEmployee.setName(rs.getString(2));
            	foundEmployee.setSalary(rs.getDouble(3));
            	
          
                 
            	employees.add( foundEmployee);
            }
            
            
           
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
		}
	

	
//UPDATE

public void updateById(int id, double modifiedSalary) {
	
	
	
Connection con=null;
PreparedStatement pstmt= null;


try {
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table_employee", "root","root");
    pstmt = con.prepareStatement("UPDATE emp SET salary =? WHERE id=?");
   // Student foundStudent = new Student();
   //pstmt.setDouble(1,modifiedSalary); // for attempts
  //  pstmt.setInt(2,id);// for roll no
    int noOfRowSpaceUpdated = pstmt.executeUpdate();// firing query...
    System.out.println("No of records updated are"+ noOfRowSpaceUpdated);
} catch (SQLException e) {
	e.printStackTrace();
}


}



}
