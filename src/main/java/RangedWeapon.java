public class RangedWeapon extends Weapons{
    private int ammo;
    private final int MAX_AMMO;
    private AmmunitionType ammoName;


    public RangedWeapon(String itemName, int weaponDamage, int hitChance, int ammo,AmmunitionType ammoName) {
        super(itemName, weaponDamage, hitChance);
        this.ammo = ammo;
        this.ammoName = ammoName;
        this.MAX_AMMO = ammo;

    }
    public int getAmmo(){
        return ammo;
    }

    public int getMAX_AMMO() {
        return MAX_AMMO;
    }

    public void useOneShot(){
        ammo--;
    }
    public AmmunitionType getAmmoName(){
        return ammoName;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
