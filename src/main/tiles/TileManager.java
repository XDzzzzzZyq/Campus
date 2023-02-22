package main.tiles;

import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.*;

import main.GUI;
import main.tiles.Tiles.TileTypes;

public class TileManager {
    
    GUI gui;
    public static Tiles[] tiles;
    
    //Constructor 
    public TileManager(GUI gui) {
        this.gui = gui;

        tiles = new Tiles[8];

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
            tiles[4].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Gras.png"));

            tiles[5] = new Tiles(TileTypes.TILE_LAKE);
            tiles[5].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Lake.png"));

            tiles[6] = new Tiles(TileTypes.TILE_FIEL);
            tiles[6].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Fiel.png"));

            tiles[7] = new Tiles(TileTypes.TILE_TILE);
            tiles[7].t_image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tile.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tiles GetTile(TileTypes _type){
        return tiles[_type.GetCode()];
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tiles[0].t_image, 0, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[1].t_image, 48, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[4].t_image, 96, 0, gui.tileSize, gui.tileSize, null);

    }
    
}
