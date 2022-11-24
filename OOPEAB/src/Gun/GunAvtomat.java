package src.Gun;

public class GunAvtomat extends Weapon{
    int speed;
    public GunAvtomat(int maxCartridges,int speed) {
        super(maxCartridges,maxCartridges);
        if(speed<1) throw new IllegalArgumentException();
        this.speed=speed;

    }
    public GunAvtomat(int maxCartridges) {
        this(maxCartridges,maxCartridges/2);
    }
    public GunAvtomat() {
        this(30,30);
    }

    @Override
    public void shoot() {
        shoot(1);
    }

    public void shoot(int n) {
        for (int i=0;i<n*speed;i++)
        {
            if(getCartridges()>0) {
                System.out.println("Бах");
                setCartridges(getCartridges()-1);
            }else{
                System.out.println("Клац");
            }
        }
    }
}
