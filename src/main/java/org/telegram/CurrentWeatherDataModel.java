package org.telegram;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherDataModel implements Serializable {
    private float feelslike_c;
    private float feelslike_f;
    private String last_updated;
    private float wind_kph;
    private float pressure_in;
    private float uv;
    private int humidity;
    private int cloud;

    public CurrentWeatherDataModel() {
    }

    public CurrentWeatherDataModel(float feelslike_c, float feelslike_f, String last_updated, float wind_kph, float pressure_in, float uv, int humidity, int cloud) {
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.last_updated = last_updated;
        this.wind_kph = wind_kph;
        this.pressure_in = pressure_in;
        this.uv = uv;
        this.humidity = humidity;
        this.cloud = cloud;
    }

    public float getFeelslike_c() {
        return feelslike_c;
    }

    public float getFeelslike_f() {
        return feelslike_f;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public float getWind_kph() {
        return wind_kph;
    }

    public float getPressure_in() {
        return pressure_in;
    }

    public float getUv() {
        return uv;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setFeelslike_c(float feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public void setFeelslike_f(float feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public void setWind_kph(float wind_kph) {
        this.wind_kph = wind_kph;
    }

    public void setPressure_in(float pressure_in) {
        this.pressure_in = pressure_in;
    }

    public void setUv(float uv) {
        this.uv = uv;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    @Override
    public String toString() {
        return "Current Weather: \n" +
                "feelslike(c)=" + feelslike_c+
                ", feelslike(f)=" + feelslike_f +
                ", last updated=\'" + last_updated + '\'' +
                ", wind kph=" + wind_kph +
                ", pressure in=" + pressure_in +
                ", uv=" + uv +
                ", humidity=" + humidity +
                ", cloud=" + cloud;
    }
}