package lab6;

abstract class AbstractEmployee implements Employee{
 String name;
 JobType job_type;
 double base_salary;
 
 
 public AbstractEmployee() {
  name = "";
  base_salary = 0.0;
 }
 
 public AbstractEmployee(String name, JobType job_type, double base_salary) {
  this.name = name;
  this.job_type = job_type;
  this.base_salary = base_salary;
 }
 
 public String getName() {
  return name;
 }
 
 
 
}