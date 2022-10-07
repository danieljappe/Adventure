public class RangedWeapon extends Weapons{
    private int ammo;
    private AmmunitionType ammoType;


    public RangedWeapon(String itemName, int weaponDamage, int ammo,AmmunitionType ammoType) {
        super(itemName, weaponDamage);
        this.ammo = ammo;
        this.ammoType = ammoType;
    }
    public int getShots(){
        return ammo;
    }
    public void useOneShot(){
        ammo--;
    }
    public AmmunitionType getAmmoType(){
        return ammoType;
    }

}
