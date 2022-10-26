package src.Department;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if(this==department.getBoss()) return name + " начальник отдела " + department.getName();
        return name + " работает в отделе " + department.getName() + ", начальник: " + department.getBoss().getName();
    }


}
