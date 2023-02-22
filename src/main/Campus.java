package main;
import main.tiles.TileManager;
import main.tiles.Tiles;
import main.tiles.Tiles.TileTypes;
import javax.swing.*;
import java.awt.*;
import java.time.format.FormatStyle;

public class Campus extends Const{

    public static Renderer m_renderer;
    public static JFrame m_window;
    public static TileManager m_tmanager;

    public static Map[] m_maps;
    public static int m_activa_map = 0;

    public static Timer m_time;

    public static Characters[] m_characters;
    public static PlayerOld m_player;

    public static boolean debug = false;

    public static void main(String[] args){
        Init(args);
        while(Run());
        Terminate();

        //new GUI();

    }

    public static void Init(String[] args){

        m_renderer = new Renderer();
        m_tmanager = new TileManager(m_renderer);

        m_window = new JFrame();
        m_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_window.setResizable(false);
        m_window.setSize(TILE_SCAL*32, TILE_SCAL*18);
        m_window.setTitle("DKU Campus Simulation");
        m_window.setLocationRelativeTo(null);
        m_window.setVisible(true);
        m_window.requestFocusInWindow();
        
        In config = new In("config.txt");
        String map_data = config.readLine();                    if(debug)System.out.println(map_data);
        String[] map_names = map_data.split(" ", -1);

        m_maps = new Map[map_names.length];                     if(debug)System.out.println(map_names.length);
        for(int i = 0; i<map_names.length; i++){                if(debug)System.out.println(map_names[i]);
            m_maps[i] = new Map(m_tmanager);
            m_maps[i].ReadCSV(map_names[i]);                    
        }
        m_maps[0].mp_activated = true;

        int defult_time = Integer.parseInt(config.readLine());             if(debug)System.out.println(defult_time);
        m_time = new Timer();
        m_time.TimeReset(defult_time);
        String[] player_pos = config.readLine().split(" ", -1);     if(debug)System.out.println(player_pos[0]);

        int ini_x = Integer.parseInt(player_pos[0]);
        int ini_y = Integer.parseInt(player_pos[1]);

        m_player = new PlayerOld(ini_x, ini_y, m_renderer.GetKeyInput());
        m_renderer.SetCamera(ini_x, ini_y);

        int character_counts = Integer.parseInt(config.readLine());        if(debug)System.out.println(character_counts);
        m_characters = new Characters[character_counts];
        for(int i = 0; i<character_counts; i++){
            String[] character_data = config.readLine().split(" ", -1);
            int dir = Integer.parseInt(character_data[0]);
            int x   = Integer.parseInt(character_data[1]);
            int y   = Integer.parseInt(character_data[2]);

            m_characters[i] = new Characters(dir, x, y);        if(debug)System.out.println(m_characters[i].p_pos.toString());
        }

        m_renderer.SetData(m_player, m_maps);
        m_window.addKeyListener(m_renderer.GetKeyInput());
        m_window.add(m_renderer);
        m_window.show();

        System.out.println(m_player.p_pos.toString());
    }

    public static void Update(){
        if(m_renderer.GetKeyInput().active_move == 0) {
            // interact with blocks
            if(m_maps[m_activa_map].GetTileTypes(m_player.p_pos) == Tiles.TileTypes.TILE_ENTR){
                // do something
            }
        }
    }

    public static boolean Run(){

        // Reset
        m_time.NextFrame();

        // State Update
        if(m_renderer.IsClicked()){
            boolean[] avail_move = m_maps[m_activa_map].CheckAvailMove(m_player.p_tar);
            //boolean[] avail_move = {true, true, true, true};
            m_player.Update(avail_move);
        } 
        m_player.slerp();
        m_renderer.MoveCamera();
        System.out.print("");

        if(debug){ 
            System.out.println(m_player.p_tar.toString());
            System.out.println(m_maps[m_activa_map].GetTileTypes(m_player.p_tar).GetName());
        }

        return true;
    }

    public static void Terminate(){

    }
}