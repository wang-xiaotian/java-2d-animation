import java.util.ArrayList;
import java.util.List;

/**
 * load rooms and control positions on the map
 */
class GameMap {
    private static GameMap gameMapInstance = new GameMap();
    private List<Room> rooms = new ArrayList<>();

    private GameMap(){
        this.demoMap();
    }

    public static GameMap getInstance(){
        if(gameMapInstance==null){
            GameMap.gameMapInstance = new GameMap();
        }
        return GameMap.gameMapInstance;
    }

    private void demoMap(){
        this.rooms.add(new Room("room1", 250, 180));
        this.rooms.add(new Room("room2", 280, 320));
        this.rooms.add(new Room("room3", 180, 500));
        this.rooms.add(new Room("room4", 600, 180));
    }

    public List<Room> getRooms(){
        return this.rooms;
    }
}
