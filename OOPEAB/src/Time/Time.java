package src.Time;

public class Time {
    private int minute,hour,second;
    public Time (int second) throws Exception {
        if (second<0) throw new Exception("Колличестов секунд не может быть отрицательным");
        this.second=second%86400;
        this.time();
    }

    public Time(int hour, int minute,int second ) throws Exception {

        this(hour*3600+minute*60+second);
    }

    private void time(){
        this.hour=(int)second/3600;
        this.minute=(int)second%3600/60;
        this.second=second%3600%60%60;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return (hour<10?"0":"") + hour+":"+(minute<10?"0":"")+minute+":"+(second<10?"0":"")+second;
    }
}
