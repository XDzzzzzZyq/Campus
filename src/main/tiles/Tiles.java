package main.tiles;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Tiles{

    /*
     *  Types
     */

    public enum TileTypes{
        TILE_ROAD(0, "Road"),
        TILE_NONE(1, "None"), 
        TILE_ROOF(2, "Roof"), 
        TILE_ENTR(3, "Entr"),
        TILE_GRAS(4, "Gras"), 
        TILE_LAKE(5, "Lake"), 
        TILE_FIEL(6, "Fiel"),
        TILE_TILE(7, "Tile"),
        TILE_TREE(8, "Tree");

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
    public static final TileTypes TILE_ROAD = TileTypes.TILE_ROAD;
    public static final TileTypes TILE_ENTR = TileTypes.TILE_ENTR;
    public static final TileTypes TILE_FIEL = TileTypes.TILE_FIEL;
    public static final TileTypes TILE_ROOF = TileTypes.TILE_ROOF;
    public static final TileTypes TILE_TILE = TileTypes.TILE_TILE;
    public static final TileTypes TILE_TREE = TileTypes.TILE_TREE;



    /*
     *  Instance variables & methods
     */

    private TileTypes t_type;

    public BufferedImage t_image;
    public boolean t_walkable = true;
    public boolean t_interactable = false;

    //public Events t_event = null;

    public void RenderTile(){

    }
    /* event functions causing problems in testing
    public void OnEvent(){
        if(t_interactable) t_event.OnEvent(t_type);

    }
    */

    public TileTypes GetType(){
        return t_type;
    }

    /*
     *  Constructor
     */

    public Tiles(TileTypes _t){
        t_type = _t;

        if(t_type==TILE_ENTR) t_interactable = true;

        switch(t_type){
            case TILE_LAKE:
            case TILE_ROOF:
            case TILE_NONE:
                t_walkable = false;            
        }
    }

    /*
     *  Static methods
     */

    public static TileTypes ParseType(int _inp){
        // parse integer from csv file
        // for adaptbility
        switch(_inp){
            case 0 : return TILE_ROAD;
            case 1 : return TILE_NONE;
            case 2 : return TILE_ROOF;
            case 3 : return TILE_ENTR;
            case 4 : return TILE_GRAS;
            case 5 : return TILE_LAKE;
            case 6 : return TILE_FIEL;
            case 7 : return TILE_TILE;
            case 8 : return TILE_TREE;
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