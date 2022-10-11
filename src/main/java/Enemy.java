public class Enemy {
    private String enemyName;
    private int enemyHealth;

    public Enemy(String enemyName, int enemyHealth){
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
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

}
