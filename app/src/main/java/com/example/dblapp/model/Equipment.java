package com.example.dblapp.model;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import java.io.Serializable;

public class Equipment implements Serializable {

    private double firstSlotMin;
    private double firstSlotMax;

    private double secondSlotMin;
    private double secondSlotMax;

    private double thirdSlotMin;
    private double thirdSlotMax;

    private double firstSlotAvg;
    private double secondSlotAvg;
    private double thirdSlotAvg;

    private int firstSlotPeso;
    private int secondSlotPeso;
    private int thirdSlotPeso;

    public Equipment(){}

    public void updateAvg(){
        updateFistAvg();
        updateSecondAvg();
        updateThirdAvg();

    }

    public void updateFistAvg(){
        if(firstSlotMax != 0.0 && firstSlotMin != 0.0)
            this.firstSlotAvg = (firstSlotMax + firstSlotMin) / 2;
        else
            this.firstSlotAvg = 0.0;
    }

    public void updateSecondAvg(){
        if(secondSlotMax != 0.0 && secondSlotMin != 0.0)
            this.secondSlotAvg = (secondSlotMax + secondSlotMin) / 2;
        else
            this.secondSlotAvg = 0.0;
    }

    public void updateThirdAvg(){
        if(thirdSlotMax != 0.0 && thirdSlotMin != 0.0)
            this.thirdSlotAvg = (thirdSlotMax + thirdSlotMin) / 2;
        else
            this.thirdSlotAvg = 0.0;
    }

    public double getFirstSlotMin() {
        return firstSlotMin;
    }

    public void setFirstSlotMin(double firstSlotMin) {
        this.firstSlotMin = firstSlotMin;
        updateFistAvg();
    }

    public double getFirstSlotMax() {
        return firstSlotMax;
    }

    public void setFirstSlotMax(double firstSlotMax) {
        this.firstSlotMax = firstSlotMax;
        updateFistAvg();
    }

    public double getSecondSlotMin() {
        return secondSlotMin;
    }

    public void setSecondSlotMin(double secondSlotMin) {
        this.secondSlotMin = secondSlotMin;
        updateSecondAvg();
    }

    public double getSecondSlotMax() {
        return secondSlotMax;
    }

    public void setSecondSlotMax(double secondSlotMax) {
        this.secondSlotMax = secondSlotMax;
        updateSecondAvg();
    }

    public double getThirdSlotMin() {
        return thirdSlotMin;
    }

    public void setThirdSlotMin(double thirdSlotMin) {
        this.thirdSlotMin = thirdSlotMin;
        updateThirdAvg();
    }

    public double getThirdSlotMax() {
        return thirdSlotMax;
    }

    public void setThirdSlotMax(double thirdSlotMax) {
        this.thirdSlotMax = thirdSlotMax;
        updateThirdAvg();
    }

    public double getFirstSlotAvg() {
        return firstSlotAvg;
    }

    public void setFirstSlotAvg(double firstSlotAvg) {
        this.firstSlotAvg = firstSlotAvg;
    }

    public double getSecondSlotAvg() {
        return secondSlotAvg;
    }

    public void setSecondSlotAvg(double secondSlotAvg) {
        this.secondSlotAvg = secondSlotAvg;
    }

    public double getThirdSlotAvg() {
        return thirdSlotAvg;
    }

    public void setThirdSlotAvg(double thirdSlotAvg) {
        this.thirdSlotAvg = thirdSlotAvg;
    }

    public int getFirstSlotPeso() {
        return firstSlotPeso;
    }

    public void setFirstSlotPeso(int firstSlotPeso) {
        this.firstSlotPeso = firstSlotPeso;
    }

    public int getSecondSlotPeso() {
        return secondSlotPeso;
    }

    public void setSecondSlotPeso(int secondSlotPeso) {
        this.secondSlotPeso = secondSlotPeso;
    }

    public int getThirdSlotPeso() {
        return thirdSlotPeso;
    }

    public void setThirdSlotPeso(int thirdSlotPeso) {
        this.thirdSlotPeso = thirdSlotPeso;
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, double value) {
        if(value == 0.0){
            view.setText("");
            return;
        }
        view.setText(Double.toString(value));
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        if(value == 0){
            view.setText("");
            return;
        }
        view.setText(Integer.toString(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static double getText(TextView view) {
        if (view.getText() != null && view.getText().toString().isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(view.getText().toString());
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getTextInt(TextView view) {
        if (view.getText() != null && view.getText().toString().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(view.getText().toString());
    }
}
