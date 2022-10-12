public class MeleeWeapon extends Weapons{

    public MeleeWeapon(String itemName,int weaponDamage, int hitChance) {
        super(itemName, weaponDamage, hitChance);

    }

    @Override
    public void useOneShot() {} // fordi der er en abstract metode i superclassen
    @Override
    public AmmunitionType getAmmoName() {return null;}
}
