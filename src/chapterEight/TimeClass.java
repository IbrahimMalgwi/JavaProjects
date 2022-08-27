package chapterEight;

public class TimeClass {
    private int minute;
    private int second;
    private int hour;

    public TimeClass( int second, int minute, int hour) {
        validate(second, minute, hour);
        this.minute = minute;
        this.second = second;
        this.hour = hour;
    }

    private void validate(int second, int minute, int hour) {
        validateSecond(second);
        validateMinute(minute);
        validateHour(hour);
    }

    private void validateHour(int hour) {
        if(hour < 0 || hour > 23) throw new IllegalArgumentException(String.format("Hour entered is %s, please enter hour between 0 and 23", hour));
    }

    private void validateMinute(int minute) {
        if(minute < 0 || minute > 59) throw new IllegalArgumentException(String.format("Minute entered is %s, please enter minute between 0 and 59", minute));
    }

    private void validateSecond(int second) {
        if(second < 0 || second > 59) throw new IllegalArgumentException(String.format("Second entered is %s, please enter second between 0 and 59", second));
    }

    public void setSecond(int second){
        validateSecond(second);
        this.second = second;
    }

    public void setMinute(int minute){
        validateMinute(minute);
        this.minute = minute;
    }

    public void setHour(int hour){
        validateHour(hour);
        this.hour = hour;
    }


}
