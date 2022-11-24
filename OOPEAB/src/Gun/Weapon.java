package src.Gun;

public abstract class Weapon {
    private int cartridges;
    private final int maxCartridges;
    public Weapon(int ammo){
        this(ammo,ammo);
    }
    public Weapon(int ammo,int maxCartridges){
        if(ammo<0 || maxCartridges<ammo) throw  new RuntimeException();
        this.cartridges=ammo;
        this.maxCartridges=maxCartridges;
    }
    public Weapon(){
        this(5,10);
    }
    public abstract void shoot();
    public int getCartridges(){return cartridges;}
    public int getMaxCartridges(){return maxCartridges;}

    public void setCartridges(int cartridges) {
        this.cartridges = cartridges;
    }

    public boolean isload()
    {
        if(cartridges==0) return false;
        return true;
    }
    public int load(int ammo)  {
        if(ammo<0) throw new IllegalArgumentException();
        if(ammo>maxCartridges-cartridges) {
            ammo=maxCartridges-cartridges;
            cartridges=maxCartridges;
            return ammo;
        }
        cartridges+=ammo;
        return ammo;
    }
    public int unload(){
        int ammo=cartridges;
        cartridges=0;
        return ammo;
    }
}
