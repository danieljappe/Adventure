public abstract class Weapons extends Item{
    protected int weaponDamage;

    public Weapons(String itemName, int weaponDamage) {
        super(itemName);
        this.weaponDamage=weaponDamage;
    }
}
