package main;

import javax.swing.*;
import java.awt.*;

import character.MainPlayer;
import main.tiles.TileManager;



public class Renderer extends JPanel implements Runnable{

    //Screen settings
    final int originalTileSize = 16;
    final int scale = 4;
    public final int tileSize = originalTileSize * scale; // 16 x 4 = 64x64 pixels per tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = maxScreenCol * tileSize; 
    final int screenHeight = maxScreenRow * tileSize; 

    //Game time 
    Thread gameThread;
    int FPS = 60;

    //Keyboard listener
    KeyHandler keyH = new KeyHandler();

    //Player object 
    MainPlayer mainPlayer = new MainPlayer(this, keyH);

    //Tile manager
    TileManager tileM = new TileManager(this);

    PlayerOld m_player;
    Map m_maps[];

    public Renderer() {

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

    public void SetData(PlayerOld pl, Map[] m){
        m_player = pl;
        m_maps = m;
    }

    @Override
    public void run() {


    }


    public void update() {
        mainPlayer.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // Render
        for(Map map : m_maps) if(map.mp_activated) map.RenderMap(g2);
        m_player.Render(g2);

        /*
        tileM.draw(g2);
        mainPlayer.draw(g2);

        g2.dispose(); */
    }


    public static void main(String[] args){
    
        //Booting up the GUI and the JFrame
        Renderer gui = new Renderer();
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