package src.Department;

public class Employee {
    public String name;
    public Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    @Override
    public String toString() {
        if(this==department.boss) return name + " начальник отдела " + department.name;
        return name + " работает в отделе " + department.name + ", начальник: " + department.boss.name;
    }


}
