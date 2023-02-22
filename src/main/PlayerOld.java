package main;

public class PlayerOld extends Const {

    public vec2 p_pos;      // non-decimal allowed
    public vec2 p_tar;      // only decimal
    public int p_dir = W;   // A: left, W: up, D: right, S: down

    public boolean interactable;

    public PlayerOld(int x, int y){
        p_tar = new vec2(x, y);
        p_pos = new vec2(x, y);
    }

    public void SetPos(int x, int y){
        p_tar = new vec2(x, y);
        p_pos = new vec2(x, y);
    }

    public void Move(vec2 tar){
        p_tar.add(tar);
    }

    public void Update(){

        // key - interaction

        if(StdDraw.isKeyPressed(A)) {
            p_dir = A;
            Move(new vec2(-1, 0));

        }
        if(StdDraw.isKeyPressed(W)) {
            p_dir = W;
            Move(new vec2(0, -1));

        }
        if(StdDraw.isKeyPressed(D)) {
            p_dir = D;
            Move(new vec2(1, 0));


        }
        if(StdDraw.isKeyPressed(S)) {
            p_dir = S;
            Move(new vec2(0, 1));
            
        }
        if(StdDraw.isKeyPressed(Q)) {
            // should not write here 
        }
        if(StdDraw.isKeyPressed(E)) {
            // should not write here 
        }
        if(StdDraw.isKeyPressed(SPACE)) {

        }

        p_pos.slerp(p_tar, 0.1);

    }

    public void Render(){
        switch(p_dir){
            // Left
            case A:


            break;
            // Up
            case W:


            break;
            // Right
            case D:


            break;
            // Down
            case S:



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
