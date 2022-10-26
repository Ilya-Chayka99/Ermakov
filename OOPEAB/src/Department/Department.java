package src.Department;

import java.util.ArrayList;
import java.util.List;

public class Department {
   private String name;
   private Employee boss;
    public List<Employee> employees = new ArrayList<>();
    public Department(String name, Employee boss) {
        this.name = name;
        this.boss = boss;
    }

    public Department(String name) {
        this(name,null);
    }

    public void setBoss(Employee boss) throws Exception {
        if(boss.getDepartment()!=this) throw new Exception();
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void addEmployee(Employee emp){
        employees.add(emp);
    }
    public String ptintEmployees() {
        String str=new String("");
        for(Employee emp : employees){
            str+=emp.getName()+" ";
        }
        return "[ " + str + "]";
    }
}
