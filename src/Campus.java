public class Campus extends Const{

    public static Map[] m_maps;
    public static int m_activa_map = 0;

    public static GUI m_GUI;

    public static Timer m_time;

    public static Characters[] m_characters;
    public static Player m_player;

    public static boolean debug = false;

    public static void main(String[] args){
        Init(args);
        while(Run());
        Terminate();
    }

    public static void Init(String[] args){
        In config = new In("config.txt");
        String map_data = config.readLine();                    if(debug)System.out.println(map_data);
        String[] map_names = map_data.split(" ", -1);

        m_maps = new Map[map_names.length];                     if(debug)System.out.println(map_names.length);
        for(int i = 0; i<map_names.length; i++){                if(debug)System.out.println(map_names[i]);
            m_maps[i] = new Map();
            m_maps[i].ReadCSV(map_names[i]);                    
        }
        m_maps[0].mp_activated = true;

        int defult_time = Integer.parseInt(config.readLine());             if(debug)System.out.println(defult_time);
        m_time = new Timer();
        m_time.TimeReset(defult_time);
        String[] player_pos = config.readLine().split(" ", -1);     if(debug)System.out.println(player_pos[0]);
        m_player = new Player(Integer.parseInt(player_pos[0]), Integer.parseInt(player_pos[1]));

        int character_counts = Integer.parseInt(config.readLine());        if(debug)System.out.println(character_counts);
        m_characters = new Characters[character_counts];
        for(int i = 0; i<character_counts; i++){
            String[] character_data = config.readLine().split(" ", -1);
            int dir = Integer.parseInt(character_data[0]);
            int x   = Integer.parseInt(character_data[1]);
            int y   = Integer.parseInt(character_data[2]);

            m_characters[i] = new Characters(dir, x, y);        if(debug)System.out.println(m_characters[i].p_pos.toString());
        }

        StdDraw.disableDoubleBuffering();
    }

    public static void Update(){
        if(StdDraw.isKeyPressed(E)) {
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
        boolean[] avail_move = m_maps[m_activa_map].CheckAvailMove(m_player.p_tar);
        m_player.Update(avail_move);

        // Render
        for(Map map : m_maps) if(map.mp_activated) map.RenderMap();
        for(Characters chara : m_characters) chara.Render();
        m_player.Render();

        if(debug){ 
            System.out.println(m_player.p_tar.toString());
            System.out.println(m_maps[m_activa_map].GetTileTypes(m_player.p_tar).GetName());
        }
        StdDraw.pause(30);
        StdDraw.show();

        return true;
    }

    public static void Terminate(){

    }
}