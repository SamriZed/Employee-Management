package lab6;

public class PartTimeEmployee extends AbstractEmployee{
 double rate;
 double hours;
 
 public PartTimeEmployee(String name, JobType jobType, double hours) {
  this.name =name;
  this.job_type = jobType;
  this.hours = hours;
   
 }

 @Override
 public double calculateSalary() {
  rate = 20;
  return rate * hours;
 }

 @Override
 public void displayDetails() {
  System.out.println("Name: " + name + ". Job Type is part time employee "+ "and salary is $" + calculateSalary());
  
 }

}