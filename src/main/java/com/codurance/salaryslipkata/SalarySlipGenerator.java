package com.codurance.salaryslipkata;

public class SalarySlipGenerator {
  private SalarySlipRepository salarySlipRepository;

  public SalarySlipGenerator(SalarySlipRepository salarySlipRepository) {
    this.salarySlipRepository = salarySlipRepository;
  }

  public void generateFor(Employee employee) {
    salarySlipRepository.add(employee);
  }
}
