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
    public Thread gameThread;
    public int FPS = 60;

    //Keyboard listener
    public KeyHandler r_keyinp;

    //Player object 
    public MainPlayer mainPlayer = new MainPlayer(this, r_keyinp);

    //Tile manager
    public TileManager tileM = new TileManager(this);

    public PlayerOld r_player;
    public Map r_maps[];

    public boolean clicked;

    public boolean IsClicked(){

        boolean ret = clicked;
        clicked = false;
        return ret;
    }

    public Renderer() {
        r_keyinp = new KeyHandler();
        //Game panel
        this.addKeyListener(r_keyinp);
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
        r_player = pl;
        r_maps = m;
    }

    @Override
    public void run() {

        while (gameThread != null) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public KeyHandler GetKeyInput(){ return r_keyinp; }


    public void update() {
        //mainPlayer.update();

    }

    public void paintComponent(Graphics g) {
        //if(true)System.out.println(r_keyinp.IsClicked());
        if(!clicked) clicked = r_keyinp.IsClicked();
        r_keyinp.pressed_b = r_keyinp.pressed;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // Render
        if ( r_maps==null || r_player == null){
            tileM.draw(g2);
            mainPlayer.draw(g2);
            g2.dispose(); 
        }else{
            for(Map map : r_maps) if(map.mp_activated) map.RenderMap(g2);
            r_player.Render(g2);
            g2.dispose(); 
        }
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