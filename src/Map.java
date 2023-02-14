public class Map{

    private Tiles[][] mp_tiles;
    private vec2 mp_offset;

    public void ReadCSV(String _file_name){

    }

    public Tiles.TileTypes GetTileTypes(vec2 _loc){
        return GetTileTypes((int)_loc.x, (int)_loc.y);
    }

    public Tiles.TileTypes GetTileTypes(int x, int y){
        return mp_tiles[x-(int)mp_offset.x][y-(int)mp_offset.y].GetType();
    }

    public void RenderMap(){
        
    }

    public void RenderMap(vec2 _min, vec2 _max){
        for(int i = (int)_min.x; i<_max.x; i++){
            for(int j = (int)_min.x; j<_max.x; j++){
                mp_tiles[i][j].RenderTile();
            }
        }
    }
    public static void main(String[] args){
        
    }
}