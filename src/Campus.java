public class Campus{

    public static Map[] m_maps;
    public static int m_activa_map = 0;

    public static GUI m_GUI;

    public static Timer m_time;

    public static void main(String[] args){
        Init(args);
        while(Run());
        Terminate();
    }

    public static void Init(String[] map_names){
        m_maps = new Map[map_names.length];
        for(int i = 0; i< map_names.length; i++){
            m_maps[i].ReadCSV(map_names[i]);
        }

        m_time.TimeReset();
    }

    public static boolean Run(){

        m_time.NextFrame();

        m_maps[m_activa_map].RenderMap();

        return true;
    }

    public static void Terminate(){

    }
}