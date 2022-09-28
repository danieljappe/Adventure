public class Door {
    private String name;
    private boolean isOpen;
    private String closed;
    private String open;
    private String rightKey;

    public Door(String name,boolean isOpen,String closed,String open,String rightKey){
        this.name = name;
        this.isOpen = isOpen;
        this.closed = closed;
        this.open = open;
        this.rightKey = rightKey;
    }

    public boolean isOpen(){
        return isOpen;
    }

    public void openDoor(String key){
        if(key==rightKey){
            isOpen = true;
        }
    }


}
