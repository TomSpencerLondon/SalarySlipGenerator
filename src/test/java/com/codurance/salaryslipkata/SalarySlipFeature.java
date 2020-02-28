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

  @Mock
  Console console;

  @Mock
  Employee employee;

  @BeforeEach
  void setUp() {
    salarySlipGenerator = new SalarySlipGenerator();
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
