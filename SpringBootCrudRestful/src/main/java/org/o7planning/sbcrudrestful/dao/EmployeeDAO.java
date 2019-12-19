package org.o7planning.sbcrudrestful.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.o7planning.sbcrudrestful.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	private static final Map<String, Employee> empMap=new HashMap<String,Employee>();
	
	static {
		initEmps();
	}
	
	private static void initEmps() {
		
		Employee emp1=new Employee("EO1","Vijaya","Clerk");
		Employee emp2=new Employee("EO2","Chandra","Salesman");
		Employee emp3=new Employee("EO3","Reddy","Manager");
		
		empMap.put(emp1.getEmpNo(), emp1);
		empMap.put(emp2.getEmpNo(), emp2);
		empMap.put(emp3.getEmpNo(), emp3);
		
	}
	
	public Employee getEmployee(String empNo) {
		return  empMap.get(empNo);
		
	}
	
	public Employee addEmployee(Employee emp) {
		empMap.put(emp.getEmpNo(),emp);
		return emp;
	}
	
	
	public  Employee updateEmployee(Employee emp) {
		empMap.put(emp.getEmpNo(),emp);
		return emp;
	}
	
	public  void deleteEmployee(String empNO) {
		empMap.remove(empNO);
		
	}
	
	public List<Employee> getAllEmployees(){
		Collection<Employee> C=empMap.values();
		List<Employee> list=new ArrayList<>();
		list.addAll(C);
		return list;
	}
}
	

