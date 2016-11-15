package com.phicomm.keeprunningdemo1.bean;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/8 16:44
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class SportDetails {
    private String distance;
    private String time;
    private String speed;
    private String step;

    public SportDetails(String distance, String time, String speed, String step) {
        this.distance = distance;
        this.time = time;
        this.speed = speed;
        this.step = step;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "SportDetails{" +
                "distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                ", speed='" + speed + '\'' +
                ", step='" + step + '\'' +
                '}';
    }
}
