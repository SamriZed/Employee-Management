package lab6;

public class InternEmployee extends AbstractEmployee{
 double stipend;
 
 public InternEmployee(String name, JobType jobType) {
  this.name =name;
  this.job_type = jobType;
   
 }

 @Override
 public double calculateSalary() {
  stipend = 1000;
  return stipend;
 }

 @Override
 public void displayDetails() {
  System.out.println("Name: " + name + ". Job Type is intern "+ "and salary is $" + calculateSalary());
  
 }

}