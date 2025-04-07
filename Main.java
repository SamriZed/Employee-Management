package lab6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
 //arrayList to store employees
 static ArrayList <Employee> employees = new ArrayList<>();
 //original menu display
 public static void menu(Scanner scanner) {
  System.out.println("Enter 1 to add a new employee");
  System.out.println("Enter 2 to remove an employee");
  System.out.println("Enter 3 to display employee details");
  System.out.println("Enter 4 to display all employees");
  System.out.println("Enter 5 to exit");
 //switch case that allows user to chose what they want to do
  try {
   int choice = scanner.nextInt();
   scanner.nextLine();
   switch(choice) {
    case(1):
     addEmployee(scanner);
     break;
    case(2):
     removeEmployee(scanner);
     break;
    case(3):
     displayEmployeeDetails(scanner);
     break;
    case(4):
     displayAllEmployees();
     break;
    case(5):
     System.exit(5);
     break;
     
   }
  }catch(InputMismatchException e) { 
   System.out.println("Invalid input. Please enter a valid number."); 
   scanner.nextLine();
  }
 
 }
 //add employee method
 public static void addEmployee(Scanner scanner) {
  System.out.println("Enter name of new employee: ");
  String name = scanner.nextLine();
  System.out.println("Select job type: ");
  for (JobType type : JobType.values()) {
   System.out.println(type.ordinal() + 1 + ". " + type);
   }
  try {
  int choice = scanner.nextInt();
  scanner.nextLine(); 
  JobType jobType = JobType.values()[choice - 1];

  //switch case that uses enum
  switch (jobType) {
   case FULL_TIME:
    AbstractEmployee x = new FullTimeEmployee(name, jobType);
    employees.add(x);
    System.out.println("Employee added successfully.");
    break;
   case PART_TIME:
    System.out.println("How many hours worked?");
    double hours = scanner.nextInt();
    scanner.nextLine();
    if (hours >= 0) {
     AbstractEmployee y = new PartTimeEmployee(name, jobType, hours);
     employees.add(y);
     System.out.println("Employee added successfully.");
    }
    else {
     System.out.println("Error. Cannot work negative hours");
    }
    break;
   case INTERN:
    AbstractEmployee z = new InternEmployee(name, jobType);
    employees.add(z);
    System.out.println("Employee added successfully.");
    break;
   default:
    System.out.println("Invalid job type.");
    return;
  }
  
  }catch (ArrayIndexOutOfBoundsException e){
   System.out.println("Invalid input. Try again."); 
   
  }
  
  
 }
 //remove employee method
 public static void removeEmployee(Scanner scanner) {
  System.out.println("Enter name of employee you want to remove: ");
  String name = scanner.nextLine();
  if (verifyAccount(name) != null) {
   employees.remove(verifyAccount(name));
   System.out.println(name + " is no longer an employee");
  }
 }
 //display a specific employee method
 public static void displayEmployeeDetails(Scanner scanner) {
  System.out.println("Enter name of employee you want to view details for: ");
  String name = scanner.nextLine();
  if (verifyAccount(name) != null) {
   verifyAccount(name).displayDetails();
   
  }
 }
 //display all employees in arrayList method
 public static void displayAllEmployees() {
  System.out.println("Displaying all employees...");
  for (Employee employee : employees) {
   employee.displayDetails();
  }
 }
 //verifies that an employee exists
 public static Employee verifyAccount(String name) {
  for (Employee x : employees) {
   if (((AbstractEmployee) x).getName().equalsIgnoreCase(name)) {
    return x; 
   }
  }
  System.out.println("Employee not found.");
  return null; 
  }
 

 public static void main(String[] args) {
  
  //2 hard-coded employees 
  AbstractEmployee one = new InternEmployee("John", JobType.INTERN);
  employees.add(one);
  AbstractEmployee two = new FullTimeEmployee("Sal", JobType.FULL_TIME);
  employees.add(two);
  
  
  Scanner scanner = new Scanner(System.in);
  Boolean a =true;
  while (a) {
   menu(scanner);
  }
  scanner.close();

  

 }

}