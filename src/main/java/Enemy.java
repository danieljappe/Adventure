public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private int damage;

    public Enemy(String enemyName, int enemyHealth, int damage){
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.damage = damage;
    }

    public String getEnemyName() {
        return enemyName;
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
