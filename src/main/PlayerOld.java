package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.synth.SynthEditorPaneUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import main.Const.*;


public class PlayerOld extends Const {

    public vec2 p_pos;      // non-decimal allowed
    public vec2 p_tar;      // only decimal
    public int p_dir = W;   // A: left, W: up, D: right, S: down

    private KeyHandler p_keyinp;

    public boolean interactable;
    private int step_count;

    static BufferedImage[] p_textures;

    public PlayerOld(int x, int y, KeyHandler key){
        p_tar = new vec2(x, y);
        p_pos = new vec2(x, y);

        p_keyinp = key;

        if(p_textures == null) p_textures = new BufferedImage[8];

        try {

            p_textures[0] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/left1.png"));
            p_textures[1] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/left2.png"));

            p_textures[2] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/up1.png"));
            p_textures[3] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/up2.png"));

            p_textures[4] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/right1.png"));
            p_textures[5] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/right2.png"));

            p_textures[6] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/down1.png"));
            p_textures[7] =  ImageIO.read(getClass().getResourceAsStream("/res/mainPlayer/down2.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void SetPos(int x, int y){
        p_tar = new vec2(x, y);
        p_pos = new vec2(x, y);
    }

    public void Move(vec2 tar){
        p_tar.add(tar);
    }

    public void Update(boolean[] avail_move){

        // key - interaction
        if(p_keyinp.active_move==A && avail_move[0]) {
            p_dir = A;
            Move(new vec2(-1, 0));
            step_count++;
        }
        if(p_keyinp.active_move==W && avail_move[1]) {
            p_dir = W;
            Move(new vec2(0, -1));
            step_count++;
        }
        if(p_keyinp.active_move==D && avail_move[2]) {
            p_dir = D;
            Move(new vec2(1, 0));
            step_count++;
        }
        if(p_keyinp.active_move==S && avail_move[3]) {
            p_dir = S;
            Move(new vec2(0, 1));
            step_count++;
        }
        if(step_count>=2)step_count=0;
    }

    public void slerp(){
        p_pos.slerp(p_tar, SLERP_RATE);
    }

    public void Render(Graphics2D g2, vec2 camera, boolean centered){


        int offset = step_count;
        int x = centered ? (int)(TILE_SCAL*(16 + p_pos.x - camera.x)) : (int)(p_pos.x*TILE_SCAL);
        int y = centered ? (int)(TILE_SCAL*(9  + p_pos.y - camera.y)) : (int)(p_pos.y*TILE_SCAL);

        switch(p_dir){
            // Left
            case A:
            g2.drawImage(p_textures[0+offset], x, y, TILE_SCAL, TILE_SCAL, null);

            break;
            // Up
            case W:
            g2.drawImage(p_textures[2+offset], x, y, TILE_SCAL, TILE_SCAL, null);

            break;
            // Right
            case D:
            g2.drawImage(p_textures[4+offset], x, y, TILE_SCAL, TILE_SCAL, null);

            break;
            // Down
            case S:
            g2.drawImage(p_textures[6+offset], x, y, TILE_SCAL, TILE_SCAL, null);


            break;
        }
    }

    public static void main(String[] args){
        while(true){
            if(StdDraw.isKeyPressed(87)) System.out.println("w");
            if(StdDraw.isKeyPressed(65)) System.out.println("a");
            if(StdDraw.isKeyPressed(83)) System.out.println("s");
            if(StdDraw.isKeyPressed(68)) System.out.println("d");
            if(StdDraw.isKeyPressed(69)) System.out.println("e");
            if(StdDraw.isKeyPressed(81)) System.out.println("q");
            if(StdDraw.isKeyPressed(32)) System.out.println("space");
        }
    }

}
