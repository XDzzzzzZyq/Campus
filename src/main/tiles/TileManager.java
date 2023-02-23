package main.tiles;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.*;

import main.Renderer;
import main.tiles.Tiles.TileTypes;

public class TileManager {
    
    Renderer gui;

    public static Random t_random = new Random();
    public static Tiles[] tiles;
    public static int[] Rd_Gras = {4, 9, 10};
    public static int[] Rd_Tree = {8, 11, 12};

    TileTypes TILE_NONE = TileTypes.TILE_NONE;
    TileTypes TILE_GRAS = TileTypes.TILE_GRAS;
    TileTypes TILE_LAKE = TileTypes.TILE_LAKE;
    TileTypes TILE_ROAD = TileTypes.TILE_ROAD;
    TileTypes TILE_ENTR = TileTypes.TILE_ENTR;
    TileTypes TILE_FIEL = TileTypes.TILE_FIEL;
    TileTypes TILE_ROOF = TileTypes.TILE_ROOF;
    TileTypes TILE_TILE = TileTypes.TILE_TILE;
    TileTypes TILE_TREE = TileTypes.TILE_TREE;
    
    //Constructor 
    public TileManager(Renderer gui) {
        this.gui = gui;

        tiles = new Tiles[13];

        Init();
    }

    //Instance methods

    private void Init() {

        try {
            tiles[0] = new Tiles(TileTypes.TILE_ROAD);
            tiles[0].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Road.png"));

            tiles[1] = new Tiles(TileTypes.TILE_NONE);
            tiles[1].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/None.png"));

            tiles[2] = new Tiles(TileTypes.TILE_ROOF);
            tiles[2].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Roof.png"));

            tiles[3] = new Tiles(TileTypes.TILE_ENTR);
            tiles[3].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Entr.png"));

            tiles[4] = new Tiles(TileTypes.TILE_GRAS);
            tiles[4].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Gras0.png"));

            tiles[5] = new Tiles(TileTypes.TILE_LAKE);
            tiles[5].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Lake.png"));

            tiles[6] = new Tiles(TileTypes.TILE_FIEL);
            tiles[6].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Fiel.png"));

            tiles[7] = new Tiles(TileTypes.TILE_TILE);
            tiles[7].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tile.png"));

            tiles[8] = new Tiles(TILE_TREE);
            tiles[8].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tree0.png"));

            tiles[9] = new Tiles(TileTypes.TILE_GRAS);
            tiles[9].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Gras1.png"));

            tiles[10] = new Tiles(TileTypes.TILE_GRAS);
            tiles[10].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Gras2.png"));

            tiles[11] = new Tiles(TileTypes.TILE_TREE);
            tiles[11].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tree1.png"));

            tiles[12] = new Tiles(TileTypes.TILE_TREE);
            tiles[12].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tree2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tiles GetTile(TileTypes _type){
        int code = _type.GetCode();
        if(code == 4){
            int ind =t_random.nextInt(3);
            code = Rd_Gras[ind];
        }else if(code == 8){
            int ind =t_random.nextInt(3);
            code = Rd_Tree[ind];
        }

        return tiles[code];
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(tiles[0].t_image, 0, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[1].t_image, 64, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[4].t_image, 128, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[8].t_image, 0, 64, gui.tileSize, gui.tileSize, null);


    }
    
}
