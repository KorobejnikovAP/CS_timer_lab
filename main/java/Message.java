
import java.io.Serializable;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armok
 */
public class Message implements Serializable{
    int hour;
    int min;
    int sec;
    
    ArrayList<Ivent> iv = new ArrayList<>();

    public Message(int hour, int min, int sec,  ArrayList<Ivent> iv) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        this.iv = iv;
    }

    
    public ArrayList<Ivent> getIv() {
        return iv;
    }

    public void setIv(ArrayList<Ivent> iv) {
        this.iv = iv;
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
    
    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }
    
    @Override
    public String toString() {
        return "{" + hour + ":" + min + ":" +sec + "}";
    }
}
