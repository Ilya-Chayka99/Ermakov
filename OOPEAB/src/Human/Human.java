package src.Human;


import src.Name.Name;

public class Human {
   private Name name;
   private final Human father;
   private double height;

    public Human(Name name, double height, Human father) throws Exception {
        if(height<0||height>500) throw new Exception("рост должен быть положительный и небольше 500");
        this.name = name;
        this.height = height;
        this.father = father;
    }
    public Human(Name name, double height) throws Exception {

        this(name,height,null);
    }

    public Human(String name,double height) throws Exception {
        this(new Name(name),height);
    }
    public Human(String name,double height,Human father) throws Exception {
        this(new Name(name),height,father);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws Exception {
        if(height<0||height>500) throw new Exception("рост должен быть положительный и небольше 500");
        this.height = height;
    }

    public Human getFather() {
        return father;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        if(this.father==null)  return this.name.toString()+
                ", рост=" + this.height;
        if(this.name.getPatronymic().isEmpty())
            if(this.name.getSurname().isEmpty())
                return this.name.toString()+" "+ this.father.name.getName()+"ович"+ " "+this.father.name.getSurname()+
                    ", рост=" + this.height+" "+this.father.name.toString();
            else return this.name.toString()+" "+ this.father.name.getName()+"ович"+
                    ", рост=" + this.height+" "+this.father.name.toString() ;
        return this.name.toString()+
                ", рост=" + this.height+" "+this.father.toString();
    }
}
