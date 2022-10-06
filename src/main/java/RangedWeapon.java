public class RangedWeapon extends Weapons{
    public int ammo;

    public RangedWeapon(String itemName, int weaponDamage, int ammo) {
        super(itemName, weaponDamage);
        this.ammo = ammo;
    }
    public int getShots(){
        return ammo;
    }
    public void useOneShot(){
        ammo--;
    }

}
