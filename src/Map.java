public class Map{

    private Tiles[][] mp_tiles;
    private vec2 mp_offset = new vec2(0, 0);
    private vec2 mp_size;

    public String mp_name;

    public void ReadCSV(String _file_name){
        In fp = new In("maps/"+_file_name+".in.csv");
        String[] map_info = fp.readLine().split(",", -1);

        assert map_info.length == 3;  // name width height

        mp_size = new vec2(Integer.parseInt(map_info[1]), Integer.parseInt(map_info[2]));

        mp_tiles = new Tiles[(int)mp_size.x][(int)mp_size.y];

        for(int i = 0; i < mp_size.y; i++){
            String[] line = fp.readLine().split(",", -1);
            assert line.length == mp_size.x;

            for(int j = 0; j < mp_size.x; j++){
                mp_tiles[j][i] = new Tiles(Tiles.ParseType(Integer.parseInt(line[j])));
            }
        }
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
        Map testmap = new Map();

        testmap.ReadCSV(args[0]);
        testmap.Debug();
    }

    public void Debug(){
        System.out.println("map name: "+mp_name);
        System.out.println("size: "+mp_size);
        System.out.println("offset: "+mp_offset);
        for(Tiles[] l : mp_tiles){
            for(Tiles t : l){
                t.Debug(true);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}