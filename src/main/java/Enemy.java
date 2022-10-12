public class Enemy {
    private String enemyName;
    private String shortName;
    private int enemyHealth;
    private int damage;

    public Enemy(String enemyName, int enemyHealth, int damage){
        this.enemyName = enemyName;
        this.shortName = enemyName;
        this.enemyHealth = enemyHealth;
        this.damage = damage;
    }

    public Enemy(String enemyName, String shortName, int enemyHealth, int damage){
        this.enemyName = enemyName;
        this.shortName = shortName;
        this.enemyHealth = enemyHealth;
        this.damage = damage;
    }

    public Enemy(String enemyName, String shortName, int enemyHealth, int damage, String enemyItem){
        this.enemyName = enemyName;
        this.shortName = shortName;
        this.enemyHealth = enemyHealth;
        this.damage = damage;
        this.enemyItem = enemyItem;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString(){
        return enemyName;
    }

}
