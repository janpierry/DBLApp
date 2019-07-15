package com.example.dblapp.model;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import com.example.dblapp.R;

public class EquipUnit extends Equipment {

    private double firstSlotValue;
    private double secondSlotValue;
    private double thirdSlotValue;

    private double firstSlotScore;
    private double secondSlotScore;
    private double thirdSlotScore;
    private double itemScore;

    public EquipUnit() {
        super();
    }

    public EquipUnit(Equipment equipment) {
        super();

        setFirstSlotMin(equipment.getFirstSlotMin());
        setFirstSlotMax(equipment.getFirstSlotMax());
        setFirstSlotAvg(equipment.getFirstSlotAvg());
        setFirstSlotPeso(equipment.getFirstSlotPeso());

        setSecondSlotMin(equipment.getSecondSlotMin());
        setSecondSlotMax(equipment.getSecondSlotMax());
        setSecondSlotAvg(equipment.getSecondSlotAvg());
        setSecondSlotPeso(equipment.getSecondSlotPeso());

        setThirdSlotMin(equipment.getThirdSlotMin());
        setThirdSlotMax(equipment.getThirdSlotMax());
        setThirdSlotAvg(equipment.getThirdSlotAvg());
        setThirdSlotPeso(equipment.getThirdSlotPeso());
    }

    public void calculateScore() {
        setFirstSlotScore(calculateFirstSlotScore());
        setSecondSlotScore(calculateSecondSlotScore());
        setThirdSlotScore(calculateThirdSlotScore());

        setItemScore((firstSlotScore * getFirstSlotPeso() + secondSlotScore * getSecondSlotPeso() + thirdSlotScore * getThirdSlotPeso())
                        / (getFirstSlotPeso() + getSecondSlotPeso() + getThirdSlotPeso()));
    }

    public double calculateFirstSlotScore(){
        if(firstSlotValue > getFirstSlotMin()){
            return ((firstSlotValue - getFirstSlotMin()) / (getFirstSlotMax() - getFirstSlotMin())) * 10;
        }
        return 0.0;
    }

    public double calculateSecondSlotScore(){
        if(secondSlotValue > getSecondSlotMin()){
            return ((secondSlotValue - getSecondSlotMin()) / (getSecondSlotMax() - getSecondSlotMin())) * 10;
        }
        return 0.0;
    }

    public double calculateThirdSlotScore(){
        if(thirdSlotValue > getThirdSlotMin()){
            return ((thirdSlotValue - getThirdSlotMin()) / (getThirdSlotMax() - getThirdSlotMin())) * 10;
        }
        return 0.0;
    }

    public double getFirstSlotValue() {
        return firstSlotValue;
    }

    public void setFirstSlotValue(double firstSlotValue) {
        this.firstSlotValue = firstSlotValue;
    }

    public double getSecondSlotValue() {
        return secondSlotValue;
    }

    public void setSecondSlotValue(double secondSlotValue) {
        this.secondSlotValue = secondSlotValue;
    }

    public double getThirdSlotValue() {
        return thirdSlotValue;
    }

    public void setThirdSlotValue(double thirdSlotValue) {
        this.thirdSlotValue = thirdSlotValue;
    }

    public double getItemScore() {
        return itemScore;
    }

    public void setItemScore(double itemScore) {
        this.itemScore = itemScore;
    }

    public double getFirstSlotScore() {
        return firstSlotScore;
    }

    public void setFirstSlotScore(double firstSlotScore) {
        this.firstSlotScore = firstSlotScore;
    }

    public double getSecondSlotScore() {
        return secondSlotScore;
    }

    public void setSecondSlotScore(double secondSlotScore) {
        this.secondSlotScore = secondSlotScore;
    }

    public double getThirdSlotScore() {
        return thirdSlotScore;
    }

    public void setThirdSlotScore(double thirdSlotScore) {
        this.thirdSlotScore = thirdSlotScore;
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, double value) {
        if (value == 0.0 && view.getId() != R.id.tv_score) {
            view.setText("");
            return;
        }
        view.setText(Double.toString(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static double getText(TextView view) {
        if (view.getText() != null && view.getText().toString().isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(view.getText().toString());
    }
}
