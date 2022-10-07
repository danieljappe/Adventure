public class Key extends Item{

private KeyType keyType;
    public Key(String itemName,KeyType keyType){
        super(itemName);
        this.keyType = keyType;
    }
    public KeyType getKeyType(){
        return keyType;
    }


}
