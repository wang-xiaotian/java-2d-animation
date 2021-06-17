/**
 * servers as our room or node where the pla
 */
class Room {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name; // can be enum
    private int dx;
    private int dy;

    Room(String name, int x, int y){
        this.name = name;
        this.dx = x;
        this.dy = y;
    }

    int getDx(){
        return this.dx;
    }

    int getDy(){
        return this.dy;
    }

    void setCoordinates(int x, int y){
        this.dx = x;
        this.dy = y;
    }
}
