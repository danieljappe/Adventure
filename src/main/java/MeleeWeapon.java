public class MeleeWeapon extends Weapons{

    public MeleeWeapon(String itemName,int weaponDamage) {
        super(itemName, weaponDamage);

    }

    @Override
    public void useOneShot() {} // fordi der er en abstract metode i superclassen
    @Override
    public AmmunitionType getAmmoName() {return null;}
}
