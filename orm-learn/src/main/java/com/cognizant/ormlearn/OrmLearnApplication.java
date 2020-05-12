package com.cognizant.ormlearn;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	
	private static CountryService countryService;
	
	private static StockRepository stockRepository;
	
	private static EmployeeService employeeService;
	
	private static SkillService skillService;
	
	private static DepartmentService departmentService;

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		Country country = null;
		try {
			country = countryService.findCountryByCode("IN");
		} catch (CountryNotFoundException e) {
				System.out.println(e.getMessage());
		}
		LOGGER.debug("countries={}", countries);
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}
	
	private static void testAddCountry() {
		LOGGER.info("Start");
		Country c = new Country();
		c.setCode("ZZ");
		c.setName("Varun");
		countryService.addCountry(c);
		Country country = null;
		try {
			country = countryService.findCountryByCode("ZZ");
		} catch (CountryNotFoundException e) {
				System.out.println(e.getMessage());
		}
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}
	
	private static void testUpdateCountry() {
		LOGGER.info("Start");
		Country c = new Country();
		c.setCode("ZZ");
		c.setName("Patel");
		try {
			countryService.updateCountry(c);
		} catch (CountryNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		Country country = null;
		try {
			country = countryService.findCountryByCode("ZZ");
		} catch (CountryNotFoundException e) {
				
		}
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}
	
	private static void testDeleteCountry() {
		
		countryService.deleteCountry("ZZ");
	}
	

	private static void testSearchCountry() {
		LOGGER.info("Start");
		List<Country> countries = countryService.searchCountry("ou");
		LOGGER.debug("countries={}", countries);
		List<Country> countriess = countryService.searchCountryFirst("z");
		LOGGER.debug("countries={}", countriess);
		LOGGER.info("End");
		
		
	}
	

	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");
		countryService = context.getBean(CountryService.class);
		stockRepository = context.getBean(StockRepository.class);
		employeeService = context.getBean(EmployeeService.class);
		skillService = context.getBean(SkillService.class);
		departmentService = context.getBean(DepartmentService.class);
		
		
		/* country test functions*/
		
		//testGetAllCountries();
		//testAddCountry();
		//testUpdateCountry();
		//testDeleteCountry();
		//testSearchCountry();
		
		/*stocks test finctions below main function*/
		//testGetAllStock();
		//testFacebookSeptData();
		//testGoogleStock1250();
		/*
		 * rest are same sql query
			select * from stock order by st_volume desc limit 3;
			Select * from stock where st_code = 'NFLX' order by st_close limit 3;
		*/
		
		//testget();
		//testEmployeeSave();
		//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
		//testGetDepartment();
		//testAddSkillToEmployee();
		//testGetAllPermanentEmployees();
		//testGetAverageSalary();
		//testGetAverageDeptSalary();
		testGetAllEmployeesNative();
	}
	
	public static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employeeList = employeeService.getAllEmployeesNative();
		for (Employee employee : employeeList) {
			LOGGER.debug("employee:{}", employee);
		}
		LOGGER.info("End");
	}

	
	public static void testGetAverageDeptSalary() {
		LOGGER.debug("Salary Average "+employeeService.getAverageSalary(1));
	}
	
	public static void testGetAverageSalary() {
		LOGGER.debug("Salary Average "+employeeService.getAverageSalary());
	}
	
	public static void testGetAllPermanentEmployees() {

		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	private static void testAddSkillToEmployee() {
		
		Employee employee = employeeService.get(10);
		Skill skill = skillService.get(2);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
	}

	private static void testGetDepartment() {
		Department department = departmentService.get(2);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Employee:{}",department.getEmployeeList());
		
	}

	private static void testUpdateEmployee() {
		
		Employee employee = employeeService.get(10);
		employee.setDepartment(departmentService.get(2));
		employeeService.save(employee);
	}

	private static void testAddEmployee() {
		
		Employee employee = new Employee();
		employee.setDateOfBirth(new Date());
		employee.setDepartment(departmentService.get(1));
		employee.setName("Varun");
		employee.setSalary(10800);
		employee.setPermanent(false);
		employeeService.save(employee);
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
		}
	
//	private static void testEmployeeSave() {
//		Employee e = new Employee("Varun", 20000, true, new Date(), new Department());
//		employeeService.save(e);
//		LOGGER.debug("employee={}", employeeService.get(1));
//	}

	private static void test() {
		LOGGER.info("Start");
		LOGGER.debug("employee={}", employeeService.get(1));
		LOGGER.debug("skill={}", skillService.get(1));
		LOGGER.debug("department={}", departmentService.get(1));
		LOGGER.info("End");
		
	}

	private static void testGoogleStock1250() {
		LOGGER.info("Start");
		LOGGER.debug("stock={}", stockRepository.findGoogleStock1250());
		LOGGER.info("End");
	}

	private static void testGetAllStock() {
		LOGGER.info("Start");
		LOGGER.debug("stock={}", stockRepository.findAll());
		LOGGER.info("End");
	}
	
	private static void testFacebookSeptData() {
		
		LOGGER.info("Start");
		LOGGER.debug("stock={}", stockRepository.findByFacebookSeptData());
		LOGGER.info("End");
	}

}