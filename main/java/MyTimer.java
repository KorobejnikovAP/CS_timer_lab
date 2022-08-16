/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armok
 */
public class MyTimer {
    int hour = 0;
    int min  = 0;
    int sec  = 0;

    public MyTimer() {
        this.hour = 0;
        this.min  = 0;
        this.sec  = 0;
    }

    public MyTimer(int h, int m, int s) {
        this.hour = h;
        this.min  = m;
        this.sec  = s;
    }
    
    void tick () {
        sec++;
        if (sec == 60) {
            sec = 0;
            min++;
        }
        if (min == 60) {
            min = 0;
            hour++;
        }
    }
    
    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
}
