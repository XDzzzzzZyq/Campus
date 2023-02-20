public class Characters extends Const{

    public vec2 p_pos;      // only decimal allowed
    public int p_dir = W;   // A: left, W: up, D: right, S: down

    public Characters(int dir, int x, int y){
        p_pos = new vec2(x, y);
        switch(dir){
            case 0: p_dir=A; break;
            case 1: p_dir=W; break;
            case 2: p_dir=D; break;
            case 3: p_dir=S; break;
        }
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
        
    }
}