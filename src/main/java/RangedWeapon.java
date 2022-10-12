public class RangedWeapon extends Weapons{
    private int ammo;
    private AmmunitionType ammoName;


    public RangedWeapon(String itemName, int weaponDamage, int hitChance, int ammo,AmmunitionType ammoName) {
        super(itemName, weaponDamage, hitChance);
        this.ammo = ammo;
        this.ammoName = ammoName;

    }
    public int getAmmo(){
        return ammo;
    }
    public void useOneShot(){
        ammo--;
    }
    public AmmunitionType getAmmoName(){
        return ammoName;
    }

}
