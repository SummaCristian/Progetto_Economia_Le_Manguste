package it.polimi.manguste.ui.shop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import it.polimi.manguste.ui.dashboard.SensorType;

public class BigFragmentViewModel extends ViewModel {
    private MutableLiveData<String> title = new MutableLiveData<>();
    private MutableLiveData<Integer> resID = new MutableLiveData<>();
    private MutableLiveData<SensorType> type = new MutableLiveData<>();
    private MutableLiveData<String> temp1 = new MutableLiveData<>();
    private MutableLiveData<String> temp2 = new MutableLiveData<>();
    private MutableLiveData<String> temp3 = new MutableLiveData<>();
    private MutableLiveData<String> temp4 = new MutableLiveData<>();
    private MutableLiveData<String> temp5 = new MutableLiveData<>();
    private MutableLiveData<String> temp6 = new MutableLiveData<>();
    private MutableLiveData<String> temp7 = new MutableLiveData<>();
    private MutableLiveData<Integer> icon1 = new MutableLiveData<>();
    private MutableLiveData<Integer> icon2 = new MutableLiveData<>();
    private MutableLiveData<Integer> icon3 = new MutableLiveData<>();
    private MutableLiveData<Integer> icon4 = new MutableLiveData<>();
    private MutableLiveData<Integer> icon5 = new MutableLiveData<>();
    private MutableLiveData<Integer> icon6 = new MutableLiveData<>();
    private MutableLiveData<Integer> icon7 = new MutableLiveData<>();


    public LiveData<SensorType> getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type.setValue(type);
    }

    public LiveData<String> getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setValue(title);
    }

    public LiveData<Integer> getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID.setValue(resID);
    }

    public void setTitle(MutableLiveData<String> title) {
        this.title = title;
    }

    public void setResID(MutableLiveData<Integer> resID) {
        this.resID = resID;
    }

    public void setType(MutableLiveData<SensorType> type) {
        this.type = type;
    }

    public MutableLiveData<String> getTemp1() {
        return temp1;
    }

    public void setTemp1(MutableLiveData<String> temp1) {
        this.temp1 = temp1;
    }

    public MutableLiveData<String> getTemp2() {
        return temp2;
    }

    public void setTemp2(MutableLiveData<String> temp2) {
        this.temp2 = temp2;
    }

    public MutableLiveData<String> getTemp3() {
        return temp3;
    }

    public void setTemp3(MutableLiveData<String> temp3) {
        this.temp3 = temp3;
    }

    public MutableLiveData<String> getTemp4() {
        return temp4;
    }

    public void setTemp4(MutableLiveData<String> temp4) {
        this.temp4 = temp4;
    }

    public MutableLiveData<String> getTemp5() {
        return temp5;
    }

    public void setTemp5(MutableLiveData<String> temp5) {
        this.temp5 = temp5;
    }

    public MutableLiveData<String> getTemp6() {
        return temp6;
    }

    public void setTemp6(MutableLiveData<String> temp6) {
        this.temp6 = temp6;
    }

    public MutableLiveData<String> getTemp7() {
        return temp7;
    }

    public void setTemp7(MutableLiveData<String> temp7) {
        this.temp7 = temp7;
    }

    public MutableLiveData<Integer> getIcon1() {
        return icon1;
    }

    public void setIcon1(MutableLiveData<Integer> icon1) {
        this.icon1 = icon1;
    }

    public MutableLiveData<Integer> getIcon2() {
        return icon2;
    }

    public void setIcon2(MutableLiveData<Integer> icon2) {
        this.icon2 = icon2;
    }

    public MutableLiveData<Integer> getIcon3() {
        return icon3;
    }

    public void setIcon3(MutableLiveData<Integer> icon3) {
        this.icon3 = icon3;
    }

    public MutableLiveData<Integer> getIcon4() {
        return icon4;
    }

    public void setIcon4(MutableLiveData<Integer> icon4) {
        this.icon4 = icon4;
    }

    public MutableLiveData<Integer> getIcon5() {
        return icon5;
    }

    public void setIcon5(MutableLiveData<Integer> icon5) {
        this.icon5 = icon5;
    }

    public MutableLiveData<Integer> getIcon6() {
        return icon6;
    }

    public void setIcon6(MutableLiveData<Integer> icon6) {
        this.icon6 = icon6;
    }

    public MutableLiveData<Integer> getIcon7() {
        return icon7;
    }

    public void setIcon7(MutableLiveData<Integer> icon7) {
        this.icon7 = icon7;
    }
}