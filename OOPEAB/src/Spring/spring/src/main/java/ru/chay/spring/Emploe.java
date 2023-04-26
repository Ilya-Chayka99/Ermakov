package ru.chay.spring;

public class Emploe {
    private String name;
    private int id;
    private String dep;

    public Emploe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Emploe{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dep='" + dep + '\'' +
                '}';
    }
}
