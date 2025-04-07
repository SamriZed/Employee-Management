package lab6;

public class FullTimeEmployee extends AbstractEmployee{
 double salary;
 double bonus;


 public FullTimeEmployee(String name, JobType jobType) {
  this.name =name;
  this.job_type = jobType;
   
 }

 @Override
 public double calculateSalary() {
  salary = 6000;
  bonus = 500;
  return salary + bonus;
 }

 @Override
 public void displayDetails() {
  System.out.println("Name: " + name + ". Job Type is full time employee "+ "and salary is $" + calculateSalary());
  
 }

}