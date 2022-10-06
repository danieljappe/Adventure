public class RangedWeapon extends Weapons{
    private int shots;

    public RangedWeapon(String itemName, int weaponDamage, int shots) {
        super(itemName, weaponDamage);
        this.shots = shots;
    }
    public int getShots(){
        return shots;
    }
    public void useOneShot(){
        shots--;
    }

}
