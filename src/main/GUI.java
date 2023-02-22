package main;

import javax.swing.*;

import character.MainPlayer;
import main.tiles.TileManager;

import java.awt.*;

public class GUI extends JPanel implements Runnable{

    //Screen settings
    final int originalTileSize = 16;
    final int scale = 4;
    public final int tileSize = originalTileSize * scale; // 16 x 3 = 48x48 pixels per tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = maxScreenCol * tileSize; //768 pixels
    final int screenHeight = maxScreenRow * tileSize; //576 pixels

    //Game time 
    Thread gameThread;
    int FPS = 60;

    //Keyboard listener
    KeyHandler keyH = new KeyHandler();

    //Player object 
    MainPlayer mainPlayer = new MainPlayer(this, keyH);

    //Tile manager
    TileManager tileM = new TileManager(this);

    public GUI() {

        //Game panel
        this.addKeyListener(keyH);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.lightGray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.startGameThread();
  
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //Since a nanosecond is 1 billion, at 60 fps, this will give the time need per each update of the screen
        double drawInterval = 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            //delta is accumulated and if it reaches 1, it means enough time has passed for the system to repaint again
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta > 1) {
                update();
                repaint();
                delta--;
            }


        }
    }

    public void update() {
        mainPlayer.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        mainPlayer.draw(g2);

        g2.dispose();
    }


    public static void main(String[] args){
    
        //Booting up the GUI and the JFrame
        GUI gui = new GUI();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("DKU Campus Simulation");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(gui);
        window.pack();
        
        
    }

}