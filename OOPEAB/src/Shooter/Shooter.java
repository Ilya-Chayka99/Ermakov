package src.Shooter;

import src.Gun.Weapon;

public class Shooter {
    public String name;
    public Weapon p ;

    public Shooter(String name) {
        this(name,null);
    }

    public Shooter(String name, Weapon p) {
        this.name = name;
        this.p = p;
    }
    public void shoot(){
        if(p!=null)
            this.p.shoot();
        else System.out.println("не могу участвовать в перестрелке");
    }
}
