package com.codurance.salaryslipkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SalarySlipFeature {

  private SalarySlipGenerator salarySlipGenerator;
  private Employee employee;

  @Mock
  Console console;

  @Mock
  SalarySlipRepository salarySlipRepository;

  @BeforeEach
  void setUp() {
    salarySlipRepository = Mockito.mock(SalarySlipRepository.class);
    salarySlipGenerator = new SalarySlipGenerator(salarySlipRepository);
    employee = new Employee();
  }

  @Test
  public void generate_monthly_salary_slip(){
    salarySlipGenerator.generateFor(employee);

    InOrder inOrder = Mockito.inOrder(console);

    inOrder.verify(console).printLine("Employee ID: 12345");
    inOrder.verify(console).printLine("John J Doe");
    inOrder.verify(console).printLine("£416.67");
  }
}
