public class RangedWeapon extends Weapons{
    public int shots;

    public RangedWeapon(String itemName, int weaponDamage, int shots) {
        super(itemName, weaponDamage);
        this.shots = shots;
    }
}
