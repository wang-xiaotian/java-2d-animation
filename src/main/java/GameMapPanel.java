/**
 * Game map image oldmap.jpg from https://www.123rf.com/photo_147314303_old-vintage-map-with-handmade-drawings-for-treasure-games-and-fantasy-stories.html
 * Player image palyer.png from https://pngtree.com/freepng/cartoon-animal-game-character-design_4069832.html
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameMapPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 800; // panel size
    final int PANEL_HEIGHT = 600;
    final int PLAYER_WIDTH = 100; // player image size
    final int PLAYER_HEIGHT = 100;

    Image player;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 1; // how many pixels the image moves each frame
    int yVelocity = 1;
    int x = 0;
    int y = 0;
    boolean[] visited = new boolean[]{false,false,false,false}; // room is visited?
    GameMap gameMap = GameMap.getInstance();

    GameMapPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLUE);
        this.player = new ImageIcon("src/main/assets/player.png").getImage();
        this.player = this.player.getScaledInstance(PLAYER_WIDTH,PLAYER_HEIGHT, Image.SCALE_SMOOTH); // RESIZE
        this.backgroundImage = new ImageIcon("src/main/assets/oldmap.jpg").getImage();
        this.backgroundImage = this.backgroundImage.getScaledInstance(PANEL_WIDTH, PANEL_HEIGHT, Image.SCALE_SMOOTH);
        timer = new Timer(10, this); // delay is how often the timer triggers; listening this;
        timer.start();
    }

    public void paint(Graphics graph){
        super.paint(graph);
        Graphics2D graph2D = (Graphics2D) graph; // 2d offers more options than Graphics
        graph2D.drawImage(backgroundImage,0,0, null);
        graph2D.drawImage(player, x, y, null); // no observer
        for(Room r : gameMap.getRooms()){
            graph2D.setColor(Color.RED);
            graph2D.fillOval(r.getDx(), r.getDy(),20,20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: complete action listener
        if(!visited[0]){
            this.moveTo(0, gameMap.getRooms().get(0));
        } else if(!visited[1]){
            this.moveTo(1, gameMap.getRooms().get(1));
        } else if(!visited[2]){
            this.moveTo(2, gameMap.getRooms().get(2));
        } else if(!visited[3]){
            this.moveTo(3, gameMap.getRooms().get(3));
        }
        super.repaint();
    }

    /**
     * helper method for this demo; need another design to skip visitedRoom
     * move from one coordinate to another
     * @param visitedRoom
     * @param room
     */
    private void moveTo(int visitedRoom, Room room){
        if(x < room.getDx() )
            x += xVelocity;
        else if (x > room.getDx())
            x -= xVelocity;

        if(y < room.getDy() )
            y += yVelocity;
        else if (y > room.getDy())
            y -= yVelocity;

        if(x == room.getDx() && y == room.getDy()) {
            visited[visitedRoom] = true;
            System.out.println("Moved to Room:" + room.getName());
        }

    }
}
