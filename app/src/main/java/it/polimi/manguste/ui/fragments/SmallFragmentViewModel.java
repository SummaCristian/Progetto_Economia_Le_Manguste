package it.polimi.manguste.ui.fragments;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import it.polimi.manguste.ui.dashboard.SensorLevel;
import it.polimi.manguste.ui.dashboard.SensorType;

public class SmallFragmentViewModel extends ViewModel {
    private MutableLiveData<String> title = new MutableLiveData<>();
    private MutableLiveData<Integer> resID = new MutableLiveData<>();
    private MutableLiveData<String> description = new MutableLiveData<>();

    private MutableLiveData<SensorType> type = new MutableLiveData<>();


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

    public LiveData<String> getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }
}