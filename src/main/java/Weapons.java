public abstract class Weapons extends Item{
    protected int weaponDamage;
    protected int hitChance;

    public Weapons(String itemName, int weaponDamage) {
        super(itemName);
        this.weaponDamage=weaponDamage;
    }
    public Weapons(String itemName, int weaponDamage, int hitChance) {
        super(itemName);
        this.weaponDamage=weaponDamage;
        this.hitChance = hitChance;
    }

    public int getWeaponDamage(){
        return weaponDamage;
    }

    public int getHitChance() {
        return hitChance;
    }

    public abstract void useOneShot();
    public abstract AmmunitionType getAmmoName();




}
