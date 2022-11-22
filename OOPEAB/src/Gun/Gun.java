package src.Gun;

public class Gun extends Weapon{


    public Gun(int ammo) {
        super(ammo);
    }

    public Gun(int ammo, int maxCartridges) {
        super(ammo, maxCartridges);
    }

    public Gun() {
        super();
    }

    @Override
    public void shoot()
    {
        if(getCartridges()>0) {
            System.out.println("Бах");
           setCartridges(getCartridges()-1);
        }else{
            System.out.println("Клац");
        }
    }

}
