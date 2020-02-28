package com.codurance.salaryslipkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class SalarySlipGeneratorShould {
  @Mock
  Employee employee;

  @Mock
  EmployeeRepository employeeRepository;

  private SalarySlipGenerator salarySlipGenerator;

  @BeforeEach
  void setUp() {
    salarySlipGenerator = new SalarySlipGenerator();
    employee = Mockito.mock(Employee.class);
    employeeRepository = Mockito.mock(EmployeeRepository.class);
  }

  @Test public void
  stores_employee(){
    salarySlipGenerator.generateFor(employee);

    verify(employeeRepository).addEmployee(employee);
  }
}
