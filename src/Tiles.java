public class Tiles{

    /*
     *  Types
     */

    public enum TileTypes{
        TILE_NONE, TILE_GRASS, TILE_LAKE, TILE_ROOF
    }

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

        return TileTypes.TILE_NONE;
    }

    /*
     *  Test client
     */
    public static void main(String[] args){
        
    }
}