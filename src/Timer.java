public class Timer{

    private static int tm_time = 0;
    private static final int tm_interval = 10;

    public static void TimeReset(){
        TimeReset(0);
    }

    public static void TimeReset(int _time){
        tm_time = _time;
    }

    public static int GetTime(){
        return tm_time;
    }

    public static void NextFrame(){
        tm_time += tm_interval;
    }

    public static void main(String[] args){
        
    }
}