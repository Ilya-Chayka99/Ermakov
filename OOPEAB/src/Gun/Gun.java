package src.Gun;

public class Gun {
    private int cartridges;
    final int maxCartridges;

    public Gun(int cartridges) {
        this(cartridges,cartridges);
    }
    public Gun(int cartridges,int maxCartridges) {
        this.cartridges = cartridges;
        this.maxCartridges = maxCartridges;
    }
    public Gun()
    {
        this(5);
    }
    public void shot()
    {
        if(cartridges>0) {
            System.out.println("Бах");
            cartridges--;
        }else{
            System.out.println("Клац");
        }
    }
    public int load(int ammo) throws Exception {
        if(ammo<0) throw new Exception();
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
    public int getMaxCartridges() {
        return maxCartridges;
    }

    public int getCartridges() {
        return cartridges;
    }
    public boolean isload()
    {
        if(cartridges>0) return true;
        return false;
    }
}
