package character;

import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.Renderer;
import main.KeyHandler;
import main.vec2;

public class MainPlayer extends Character {
    
    Renderer gui;
    KeyHandler keyH;

    public MainPlayer(Renderer gui, KeyHandler keyH) {
        this.gui = gui;
        this.keyH = keyH;
        setDefaultValues();
        getMainPlayerImage();
    }

    public void setDefaultValues() {
        x = 200;
        y = 200;
        speed = 4;
        direction = "down";
    }
    public void update () {

        if (keyH.active_move == 1 || keyH.active_move == 1|| keyH.active_move == 1|| keyH.active_move == 1) {

        if (keyH.active_move == 1) {
            direction = "up";
            y -= speed;
        }
        else if (keyH.active_move == 1) {
            direction = "left";
            x -= speed;
        }
        else if (keyH.active_move == 1) {
            direction = "down";
            y += speed;
        }
        else if (keyH.active_move == 1) {
            direction = "right";
            x += speed;
        }

        spriteCounter++;
        if (spriteCounter > 15) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }
            else if (spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
            if (spriteNum == 1) {
                image = up1;
            }
            if (spriteNum == 2) {
                image = up2;
            }
            
            break;
            case "left":
            if (spriteNum == 1) {
                image = left1;
            }
            if (spriteNum == 2) {
                image = left2;
            }
            break;
            case "down":
            if (spriteNum == 1) {
                image = down1;
            }
            if (spriteNum == 2) {
                image = down2;
            }
            break;
            case "right":
            if (spriteNum == 1) {
                image = right1;
            }
            if (spriteNum == 2) {
                image = right2;
            }
            break;
        }
        g2.drawImage(image, x, y, gui.tileSize, gui.tileSize, null);
    }

    public static vec2 getPlayerPos(int x, int y) {
        return new vec2(x, y);
    }

    public void getMainPlayerImage() {
        try {

            up1 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/up1.png"));
            up2 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/up2.png"));

            down1 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/down1.png"));
            down2 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/down2.png"));

            left1 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/left1.png"));
            left2 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/left2.png"));

            right1 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/right1.png"));
            right2 =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/right2.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
