package main.tiles;

import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.*;

import main.GUI;
import main.tiles.Tiles.TileTypes;

public class TileManager {
    
    GUI gui;
    Tiles[] tiles;

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
    public TileManager(GUI gui) {
        this.gui = gui;

        tiles = new Tiles[9];

        getTileImage();
    }

    //Instance methods

    public void getTileImage() {

        try {
            tiles[0] = new Tiles(TILE_ROAD);
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Road.png"));

            tiles[1] = new Tiles(TILE_NONE);
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/None.png"));

            tiles[2] = new Tiles(TILE_ROOF);
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Roof.png"));

            tiles[3] = new Tiles(TILE_ENTR);
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Entr.png"));

            tiles[4] = new Tiles(TILE_GRAS);
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Gras.png"));

            tiles[5] = new Tiles(TILE_LAKE);
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Lake.png"));

            tiles[6] = new Tiles(TILE_FIEL);
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Fiel.png"));

            tiles[7] = new Tiles(TILE_TILE);
            tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tile.png"));

            tiles[8] = new Tiles(TILE_TREE);
            tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tree.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tiles[0].image, 0, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[1].image, 64, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[4].image, 128, 0, gui.tileSize, gui.tileSize, null);
        g2.drawImage(tiles[8].image, 0, 64, gui.tileSize, gui.tileSize, null);


    }
    
}
