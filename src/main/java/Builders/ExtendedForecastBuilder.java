package Builders;

import Classes.Day;
import Classes.ExtendedForecast;

import java.util.ArrayList;

public final class ExtendedForecastBuilder {
    private ArrayList<Day> extForecast;

    private ExtendedForecastBuilder() {
    }

    public static ExtendedForecastBuilder anExtendedForecast() {
        return new ExtendedForecastBuilder();
    }

    public ExtendedForecastBuilder withExtForecast(ArrayList<Day> extForecast) {
        this.extForecast = extForecast;
        return this;
    }

    public ExtendedForecast build() {
        ExtendedForecast extendedForecast = new ExtendedForecast();
        extendedForecast.setExtForecast(extForecast);
        return extendedForecast;
    }
}
