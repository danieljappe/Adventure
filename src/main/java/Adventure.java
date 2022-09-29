public class Adventure {
    private Map map = new Map();
    private Player player = new Player();

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }


    public boolean go(char direction) {
        switch (direction) {
            case 'n' -> {
                return player.goNorth();
            }
            case 's' -> {
                return player.goSouth();
            }
            case 'e' -> {
                return player.isEast();
                /*String line;
                if (player.isEast()) {
                    line = "\u001B[32mGoing east\u001B[39m \n"+
                    getCurrentRoom().getEastDescription();
                    if(true) { // door Is open
                        line += "door opens";
                        player.goEast();
                        line +=  getCurrentRoom().getRoomDescription();
                    }else{
                        line += "door is closed";
                    }
                } else {
                    line = "\u001B[31mCan´t go that way\u001B[39m";
                }
                return line;*/
            }
            case 'w' -> {
                return player.goWest();
            }
            default -> {
                return false;
            }
        }
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }
}


