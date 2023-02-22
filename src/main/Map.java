package main;

import main.tiles.TileManager;
import main.tiles.Tiles;
import main.tiles.Tiles.TileTypes;

import main.Const.*;

import javax.swing.*;
import java.awt.*;

public class Map extends Const{

    private TileManager mp_tmanager;

    private Tiles[][] mp_tiles;
    private vec2 mp_offset = new vec2(0, 0);
    private vec2 mp_size;

    public String mp_name;

    public boolean mp_activated;

    /*
     *   Reading map from .csv file
     */
    public Map(TileManager _t){
        mp_tmanager = _t;
    }

    public void ReadCSV(String _file_name){
        In fp = new In("maps/"+_file_name+".in.csv");
        String[] map_info = fp.readLine().split(",", -1);

        assert map_info.length == 5;  // name width height

        mp_size = new vec2(Integer.parseInt(map_info[1]), Integer.parseInt(map_info[2]));
        mp_offset = new vec2(Integer.parseInt(map_info[3]), Integer.parseInt(map_info[4]));

        mp_tiles = new Tiles[(int)mp_size.x][(int)mp_size.y];
        mp_name = map_info[0];

        for(int i = 0; i < mp_size.y; i++){
            String[] line = fp.readLine().split(",", -1);
            assert line.length == mp_size.x;

            for(int j = 0; j < mp_size.x; j++){
                mp_tiles[j][i] = mp_tmanager.GetTile(Tiles.ParseType(Integer.parseInt(line[j])));     
            }
        }
    }

    public Tiles.TileTypes GetTileTypes(vec2 _loc){
        vec2 local_pos = vec2.subtract(_loc, mp_offset);
        if(!local_pos.is_inRange(new vec2(0, 0), mp_size)) return Tiles.TILE_NONE;

        return mp_tiles[(int)local_pos.x][(int)local_pos.y].GetType();
    }

    public Tiles.TileTypes GetTileTypes(int x, int y){

        return GetTileTypes(new vec2(x, y));
    }

    public boolean CheckBlock(int x, int y){
        if(x<0 || x>=mp_size.x) return false;
        if(y<0 || y>=mp_size.y) return false;

        return mp_tiles[x][y].t_walkable;
    }

    public boolean[] CheckAvailMove(vec2 player_pos){
        boolean[] res = new boolean[4]; // a w d s
        vec2 local_pos = vec2.subtract(player_pos, mp_offset);
        int local_x = (int)local_pos.x;
        int local_y = (int)local_pos.y;

        res[0] = CheckBlock(local_x - 1, local_y    );   // left
        res[1] = CheckBlock(local_x    , local_y - 1);   // up
        res[2] = CheckBlock(local_x + 1, local_y    );   // right
        res[3] = CheckBlock(local_x    , local_y + 1);   // down

        //System.out.print(local_pos.toString())
        return res;
    }

    public void RenderMap(Graphics2D g2){
        RenderMap(new vec2(0, 0), mp_size, g2, false);
    }

    /*
     *   Rendering map from a 2d range
     */

    public void RenderMap(vec2 _min, vec2 _max, Graphics2D g2, boolean centered){

        vec2 local_min = vec2.subtract(_min, mp_offset);
        vec2 local_max = vec2.subtract(_max, mp_offset);
        vec2 center = vec2.scale(vec2.add(local_min, local_max), 0.5);

        for(int i = (int)local_min.x; i<local_max.x; i++){
            if(i<0 || i>=mp_size.x) continue;
            for(int j = (int)local_min.y; j<local_max.y; j++){
                if(j<0|| j>=mp_size.y) continue;
                if(mp_tiles[i][j].GetType()==TileTypes.TILE_NONE) continue;

                int x = (int)(i+mp_offset.x)*TILE_SCAL;
                int y = (int)(j+mp_offset.y)*TILE_SCAL;

                if(centered){
                    x += (16-mp_offset.x -center.x)*TILE_SCAL;
                    y += ( 9-mp_offset.y -center.y)*TILE_SCAL;
                }

                g2.drawImage(mp_tiles[i][j].t_image, x, y, TILE_SCAL, TILE_SCAL, null);
            }
        }
    }
    public static void main(String[] args){
        Map testmap = new Map(null);

        testmap.ReadCSV(args[0]);
        testmap.Debug();

        System.out.println(testmap.GetTileTypes(0, 1).GetCode());

        if(args.length == 1) return;

        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        boolean[] move = testmap.CheckAvailMove(new vec2(x, y));
        for(boolean b : move) System.out.print(b+" ");
        System.out.println();
    }

    public void Debug(){
        System.out.println("map name: "+mp_name);
        System.out.println("size: "+mp_size);
        System.out.println("offset: "+mp_offset);

        for(int y = 0; y<mp_tiles[0].length; y++){
            for(int x = 0; x<mp_tiles.length; x++){
                mp_tiles[x][y].Debug(true);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}