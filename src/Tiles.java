public class Tiles{

    /*
     *  Types
     */

    public enum TileTypes{
        TILE_NONE(0, "None"), 
        TILE_GRAS(1, "Gras"), 
        TILE_LAKE(2, "Lake"), 
        TILE_ROOF(3, "Roof");

        TileTypes(int _code, String _name){
            this._code = _code;
            this._name = _name;
        }

        private int    _code;
        private String _name;

        public int    GetCode(){ return this._code; }
        public String GetName(){ return this._name; }
    }

    public static final TileTypes TILE_NONE = TileTypes.TILE_NONE;
    public static final TileTypes TILE_GRAS = TileTypes.TILE_GRAS;
    public static final TileTypes TILE_LAKE = TileTypes.TILE_LAKE;
    public static final TileTypes TILE_ROOF = TileTypes.TILE_ROOF;

    /*
     *  Instance variables & methods
     */

    private TileTypes t_type;

    public boolean t_walkable = true;
    public boolean t_interactable = false;

    public Events t_event = null;

    public void RenderTile(){

    }

    public void OnEvent(){
        if(t_interactable) t_event.OnEvent(t_type);

    }

    public TileTypes GetType(){
        return t_type;
    }

    /*
     *  Constructor
     */

    public Tiles(TileTypes _t){
        t_type = _t;
    }

    /*
     *  Static methods
     */

    public static TileTypes ParseType(int _inp){
        // parse integer from csv file
        // for adaptbility
        switch(_inp){
            case 0: return TILE_NONE;
            case 1: return TILE_GRAS;
            case 2: return TILE_LAKE;
            case 3: return TILE_ROOF;
            case 4: return TILE_NONE;
        }

        return TILE_NONE;
    }

    /*
     *  Test client
     */
    public static void main(String[] args){
        
    }

    public void Debug(boolean print_name){
        if(print_name) System.out.print("[ "+this.t_type.GetName()+" ]");
        else           System.out.print("[ "+this.t_type.GetCode()+" ]");
    }
}