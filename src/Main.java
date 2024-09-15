import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;
    private int age;
    public Employee(String name,int id,int age){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getAge(){
        return age;
    }
    abstract double calculateSalary();
    @Override
    public  String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";

    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,int age,double monthlySalary){
        super(name,id,age);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int age,int hoursWorked,double hourlyRate){
        super(name,id,age);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWorked;
    }
}
//ArrayList<Integer> arr=new ArrayList<>();
class PayrollSystem{
    private List<Employee> employeeList;
    public  PayrollSystem()
    {
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    public void removeEmployee(int id)
    {
        Employee employeeToRemove=null;
        for(Employee employee:employeeList)
        {
            if(employee.getId()==id) {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove!=null)
        {

            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for (Employee employee:employeeList)
        {
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
         PayrollSystem payrollSystem=new PayrollSystem();
         FullTimeEmployee emp1=new FullTimeEmployee("vikas",1,25,70000.0);
         PartTimeEmployee emp2=new PartTimeEmployee("rohan",2,40,26,100);
         payrollSystem.addEmployee(emp1);
         payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing employees: ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining employee details: ");
        payrollSystem.displayEmployees();
    }
}