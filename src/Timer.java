public class Timer extends Const{

    private int tm_time = 0;
    private int tm_days = 0;

    public void TimeReset(){
        TimeReset(0);
    }

    public void TimeReset(int _time){
        tm_time = _time;
    }

    public int GetTime(){
        return tm_time;
    }

    public void NextFrame(){
        tm_time += TIME_INTERVAL;

        if(tm_time>=1440){
            tm_time -= 1440;
            tm_days ++;
        }
    }

    public static void main(String[] args){
        
    }

    public String toString(){
        int h = tm_time/60;
        return "[ "+tm_days+"d, "+h+"h, "+(tm_time-60*h)+"m ]";
    }
}