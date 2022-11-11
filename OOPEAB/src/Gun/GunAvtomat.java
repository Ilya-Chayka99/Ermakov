package src.Gun;

public class GunAvtomat extends Gun{
    int speed;
    public GunAvtomat(int cartridges) {
        super(cartridges);
    }

    public GunAvtomat(int speed, int cartridges, int maxCartridges) {
        super(cartridges, maxCartridges);
        this.speed=speed;
    }

    public GunAvtomat() {
    }


}
