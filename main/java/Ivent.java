
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armok
 */
public class Ivent implements Serializable{
    int hour;
    int min;
    int sec;
    String description = "";
    
    public Ivent() {
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
        this.description = "";
    }

    public Ivent(int hour, int min, int sec, String str) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        this.description = str;
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

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "{" + hour + ":" + min + ":" +sec + "}\n" + description;
    }
}
