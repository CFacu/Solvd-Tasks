package com.solvd.hospital.models.staff.administrative;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.models.exceptions.InsufficientFundsException;
import com.solvd.hospital.models.healthfacilities.PrivateHospital;
import com.solvd.hospital.models.staff.Employee;

public class Accountant extends Administrative {
	private static final Logger LOGGER = LogManager.getLogger(Accountant.class);
	
	public Accountant() {}	
	
	public Accountant(String firstName, String lastName, int id) {
		super(firstName, lastName, id);
	}

	public void payEmployee (PrivateHospital phospital, Employee emp) {
		try {
			phospital.getAccount().withdraw(emp.getSalary());
			emp.getAccount().deposit(emp.getSalary());
			LOGGER.info("Payment done successfully");
		} catch (InsufficientFundsException e) {
			LOGGER.error(e);
		}
	}
}
