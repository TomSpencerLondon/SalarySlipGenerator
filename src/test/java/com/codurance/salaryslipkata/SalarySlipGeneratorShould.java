package com.codurance.salaryslipkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class SalarySlipGeneratorShould {
  @Mock
  Employee employee;

  @Mock
  SalarySlipRepository salarySlipRepository;

  private SalarySlipGenerator salarySlipGenerator;
  private SalarySlipPrinter salarySlipPrinter;

  @BeforeEach
  void setUp() {
    salarySlipRepository = Mockito.mock(SalarySlipRepository.class);
    salarySlipGenerator = new SalarySlipGenerator(salarySlipRepository);
    employee = Mockito.mock(Employee.class);
  }

  @Test public void
  stores_employee(){
    salarySlipGenerator.generateFor(employee);

    verify(salarySlipRepository).add(employee);
  }

  @Test
  void prints_a_salary_slip() {
    List<SalarySlip> salarySlips = asList(new SalarySlip(employee));
    given(salarySlipRepository.allSalaries()).willReturn(salarySlips);

    verify(salarySlipPrinter).print(salarySlips);
  }
}
