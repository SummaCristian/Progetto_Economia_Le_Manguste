package it.polimi.manguste.ui.shop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import it.polimi.manguste.ui.dashboard.SensorType;

public class BigFragmentViewModel extends ViewModel {
    private MutableLiveData<String> todayTemp = new MutableLiveData<>();
    private MutableLiveData<String> minTemp = new MutableLiveData<>();
    private MutableLiveData<String> maxTemp = new MutableLiveData<>();
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

    public LiveData<String> getTodayTemp() {
        return todayTemp;
    }

    public void setTodayTemp(String todayTemp) {
        this.todayTemp.setValue(todayTemp);
    }

    public LiveData<String> getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String temp) {
        this.minTemp.setValue(temp);
    }

    public LiveData<String> getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String temp) {
        this.maxTemp.setValue(temp);
    }

    public LiveData<Integer> getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID.setValue(resID);
    }

    public void setTitle(String title) {
        this.todayTemp.setValue(title);
    }

    public LiveData<String> getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1.setValue(temp1);
    }

    public LiveData<String> getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2.setValue(temp2);
    }

    public LiveData<String> getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3.setValue(temp3);
    }

    public LiveData<String> getTemp4() {
        return temp4;
    }

    public void setTemp4(String temp4) {
        this.temp4.setValue(temp4);
    }

    public LiveData<String> getTemp5() {
        return temp5;
    }

    public void setTemp5(String temp5) {
        this.temp5.setValue(temp5);
    }

    public LiveData<String> getTemp6() {
        return temp6;
    }

    public void setTemp6(String temp6) {
        this.temp6.setValue(temp6);
    }

    public LiveData<String> getTemp7() {
        return temp7;
    }

    public void setTemp7(String temp7) {
        this.temp7.setValue(temp7);
    }

    public LiveData<Integer> getIcon1() {
        return icon1;
    }

    public void setIcon1(int icon1) {
        this.icon1.setValue(icon1);
    }

    public LiveData<Integer> getIcon2() {
        return icon2;
    }

    public void setIcon2(int icon2) {
        this.icon2.setValue(icon2);
    }

    public LiveData<Integer> getIcon3() {
        return icon3;
    }

    public void setIcon3(int icon3) {
        this.icon3.setValue(icon3);
    }

    public LiveData<Integer> getIcon4() {
        return icon4;
    }

    public void setIcon4(int icon4) {
        this.icon4.setValue(icon4);
    }

    public LiveData<Integer> getIcon5() {
        return icon5;
    }

    public void setIcon5(int icon5) {
        this.icon5.setValue(icon5);
    }

    public LiveData<Integer> getIcon6() {
        return icon6;
    }

    public void setIcon6(int icon6) {
        this.icon6.setValue(icon6);
    }

    public LiveData<Integer> getIcon7() {
        return icon7;
    }

    public void setIcon7(int icon7) {
        this.icon7.setValue(icon7);
    }
}