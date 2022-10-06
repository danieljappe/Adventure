public abstract class Weapons extends Item{
    private int weaponDamage;

    public Weapons(String itemName, int weaponDamage) {
        super(itemName);
        this.weaponDamage=weaponDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
}
