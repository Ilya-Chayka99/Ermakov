package src.Department;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    Employee boss;
    public List<Employee> employees = new ArrayList<>();
    public Department(String name, Employee boss) {
        this.name = name;
        this.boss = boss;
    }

    public Department(String name) {
        this(name,null);
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public void addEmployee(Employee emp){
        employees.add(emp);
    }
    public String ptintEmployees() {
        String str=new String("");
        for(Employee emp : employees){
            str+=emp.name+" ";
        }
        return "[ " + str + "]";
    }
}
