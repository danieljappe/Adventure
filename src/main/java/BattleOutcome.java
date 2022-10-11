import java.util.ArrayList;

public class BattleOutcome {

    private int playerDamage;
    private int enemyDamage;
    private ArrayList<TryUseWeapon> outComeList;

    BattleOutcome(){
        outComeList = new ArrayList<>();

    }
    public void addOutcome(TryUseWeapon outcome){
        outComeList.add(outcome);
    }

    public void setPlayerDamage(int playerDamage){
        this.playerDamage = playerDamage;
    }

    public void setEnemyDamage(int enemyDamage){
        this.enemyDamage = enemyDamage;
    }

}
