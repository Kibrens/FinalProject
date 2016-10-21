package Classes;

import java.util.ArrayList;

public class ExtendedForecast {

    private ArrayList<Day> extForecast;

    public ExtendedForecast(){
    }

    public ExtendedForecast(ArrayList<Day> extForecast) {
        this.extForecast = extForecast;
    }

    public ArrayList getExtForecast() {
        return extForecast;
    }

    public void setExtForecast(ArrayList extForecast) {
        this.extForecast = extForecast;
    }

    @Override
    public String toString(){
        return "Extended forecast: "+extForecast.toString();
    }
}
