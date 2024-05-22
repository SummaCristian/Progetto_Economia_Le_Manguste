package it.polimi.manguste.ui.fragments;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Objects;

import it.polimi.manguste.Listener;
import it.polimi.manguste.Observable;
import it.polimi.manguste.R;
import it.polimi.manguste.ui.dashboard.SensorLevel;
import it.polimi.manguste.ui.dashboard.SensorType;

public class SmallFragment extends Fragment implements Observable {
    // Attributes
    private SensorType type;
    private TextView titleTxt;
    private ImageView icon;
    private SensorLevel level;
    private TextView descriptionTxt;
    private ImageView editButton;
    private CardView parent;

    private SmallFragmentViewModel viewModel;

    private ArrayList<Listener> listeners = new ArrayList<>();

    // Constructor Method
    public SmallFragment() {
    }

    // Getters and Setters
    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    // Methods
    public void setData(String value, String description, SensorLevel level) {
        this.level = level;
        if (null != type) {
            viewModel.setType(type);
        }
        viewModel.setTitle(value);
        viewModel.setDescription(description);
        switch (Objects.requireNonNull(viewModel.getType().getValue())) {
            case WEATHER -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.weather_stormy);
                    case LOW -> viewModel.setResID(R.drawable.weather_rainy);
                    case MEDIUM_LOW -> viewModel.setResID(R.drawable.weather_completely_cloudy);
                    case MEDIUM_HIGH -> viewModel.setResID(R.drawable.weather_cloudy);
                    case HIGH, MAX -> viewModel.setResID(R.drawable.weather_sunny);
                }
            }
            case COUNTDOWN -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.countdown_min);
                    case LOW -> viewModel.setResID(R.drawable.countdown_low);
                    case MEDIUM_LOW -> viewModel.setResID(R.drawable.countdown_medium_low);
                    case MEDIUM_HIGH -> viewModel.setResID(R.drawable.countdown_medium_high);
                    case HIGH -> viewModel.setResID(R.drawable.countdown_high);
                    case MAX -> viewModel.setResID(R.drawable.countdown_max);
                }
            }
            case WIND_SPEED -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.wind_speed_min);
                    case LOW, MEDIUM_LOW -> viewModel.setResID(R.drawable.wind_speed_low);
                    case MEDIUM_HIGH, HIGH -> viewModel.setResID(R.drawable.wind_speed_high);
                    case MAX -> viewModel.setResID(R.drawable.wind_speed_max);
                }
            }
            case SOIL_TEMPERATURE -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.soil_temperature_min);
                    case LOW, MEDIUM_LOW -> viewModel.setResID(R.drawable.soil_temperature_low);
                    case MEDIUM_HIGH, HIGH -> viewModel.setResID(R.drawable.soil_temperature_high);
                    case MAX -> viewModel.setResID(R.drawable.soil_temperature_max);
                }
            }
            case AIR_QUALITY -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.air_quality_min);
                    case LOW -> viewModel.setResID(R.drawable.air_quality_low);
                    case MEDIUM_LOW -> viewModel.setResID(R.drawable.air_quality_medium_low);
                    case MEDIUM_HIGH -> viewModel.setResID(R.drawable.air_quality_medium_high);
                    case HIGH -> viewModel.setResID(R.drawable.air_quality_high);
                    case MAX -> viewModel.setResID(R.drawable.air_quality_max);
                }
            }
            case HUMIDITY -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.humidity_min);
                    case LOW, MEDIUM_LOW -> viewModel.setResID(R.drawable.humidity_low);
                    case MEDIUM_HIGH, HIGH -> viewModel.setResID(R.drawable.humidity_high);
                    case MAX -> viewModel.setResID(R.drawable.humidity_max);
                }
            }
            case SOIL_PH -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.soil_ph_min);
                    case LOW -> viewModel.setResID(R.drawable.soil_ph_low);
                    case MEDIUM_LOW -> viewModel.setResID(R.drawable.soil_ph_medium_low);
                    case MEDIUM_HIGH -> viewModel.setResID(R.drawable.soil_ph_medium_high);
                    case HIGH -> viewModel.setResID(R.drawable.soil_ph_high);
                    case MAX -> viewModel.setResID(R.drawable.soil_ph_max);
                }
            }
            case SOIL_HUMIDITY -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.soil_humidity_min);
                    case LOW, MEDIUM_LOW -> viewModel.setResID(R.drawable.soil_humidity_low);
                    case MEDIUM_HIGH, HIGH -> viewModel.setResID(R.drawable.soil_humidity_high);
                    case MAX -> viewModel.setResID(R.drawable.soil_humidity_max);
                }
            }
            case SOIL_NUTRIENTS -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.soil_nutrients_min);
                    case LOW, MEDIUM_LOW -> viewModel.setResID(R.drawable.soil_nutrients_low);
                    case MEDIUM_HIGH, HIGH -> viewModel.setResID(R.drawable.soil_nutrients_high);
                    case MAX -> viewModel.setResID(R.drawable.soil_nutrients_max);
                }
            }
            case CO2_CONCENTRATION -> {
                switch (level) {
                    case MIN -> viewModel.setResID(R.drawable.co2_concentration_min);
                    case LOW, MEDIUM_LOW -> viewModel.setResID(R.drawable.co2_concentration_low);
                    case MEDIUM_HIGH, HIGH -> viewModel.setResID(R.drawable.co2_concentration_high);
                    case MAX -> viewModel.setResID(R.drawable.co2_concentration_max);
                }
            }
            case SUN_EXPOSITION -> {
                viewModel.setResID(R.drawable.sun_exposition);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SmallFragmentViewModel.class);
        viewModel.getTitle().observe(this, title -> {
            titleTxt.setText(title);
        });
        viewModel.getResID().observe(this, resID -> {
            icon.setImageResource(resID);
        });
        viewModel.getDescription().observe(this, descr -> {
            descriptionTxt.setText(descr);
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO) {
            return inflater.inflate(R.layout.fragment_small_white, container, false);
        } else {
            return inflater.inflate(R.layout.fragment_small_black, container, false);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Retrieve data and display it here
        titleTxt = getView().findViewById(R.id.fragment_title);
        icon = getView().findViewById(R.id.fragment_image);
        descriptionTxt = view.findViewById(R.id.fragment_description);
        editButton = view.findViewById(R.id.edit_button);
        editButton.setVisibility(View.INVISIBLE);
        parent = view.findViewById(R.id.fragment_small_parent);
        parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                notifyListeners();
                return true;
            }
        });

        setup();
    }

    public void setup() {
        if (null != viewModel.getType().getValue()) {
            titleTxt.setText(viewModel.getTitle().getValue());
            descriptionTxt.setText(viewModel.getDescription().getValue());
            icon.setImageResource(viewModel.getResID().getValue());
        } else if (null != type) {
            switch (type) {
                case COUNTDOWN -> setData("Conto alla rovescia", "-1 mese", SensorLevel.HIGH);
                case WIND_SPEED -> setData("Velocità del vento", "35 Km/h", SensorLevel.HIGH);
                case HUMIDITY -> setData("Umidità", "50%", SensorLevel.MEDIUM_HIGH);
                case AIR_QUALITY -> setData("Qualità dell'aria", "Buona", SensorLevel.MIN);
                case SOIL_PH -> setData("pH del terreno", "7.4", SensorLevel.MEDIUM_HIGH);
                case SOIL_TEMPERATURE -> setData("Temperatura suolo", "20°C", SensorLevel.MEDIUM_HIGH);
                case SOIL_NUTRIENTS -> setData("Nutrienti nel suolo", "Ottimo", SensorLevel.HIGH);
                case SOIL_HUMIDITY -> setData("Umidità del suolo", "Ottima", SensorLevel.HIGH);
                case CO2_CONCENTRATION -> setData("Concentrazione CO2", "Ottima", SensorLevel.HIGH);
                case SUN_EXPOSITION -> setData("Esposizione media", "8h 23min", SensorLevel.MEDIUM_HIGH);
            }
        }
    }

    public void enableEditMode() {
        editButton.setVisibility(View.VISIBLE);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editData();
            }
        });
    }

    public void disableEditMode() {
        editButton.setVisibility(View.INVISIBLE);
    }

    private void editData() {
        switch (type) {
            case COUNTDOWN -> {
                switch (level) {
                    case MIN -> setData("Conto alla rovescia", "-5 mesi", SensorLevel.LOW);
                    case LOW -> setData("Conto alla rovescia", "-4 mesi", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Conto alla rovescia", "-2 mesi", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Conto alla rovescia", "-1 mese", SensorLevel.HIGH);
                    case HIGH -> setData("Conto alla rovescia", "-10 giorni", SensorLevel.MAX);
                    case MAX -> setData("Conto alla rovescia", "-6 mesi", SensorLevel.MIN);
                }
            }
            case WIND_SPEED -> {
                switch (level) {
                    case MIN -> setData("Velocità del vento", "8 Km/h", SensorLevel.LOW);
                    case LOW -> setData("Velocità del vento", "15 Km/h", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Velocità del vento", "20 Km/h", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Velocità del vento", "35 Km/h", SensorLevel.HIGH);
                    case HIGH -> setData("Velocità del vento", "40 Km/h", SensorLevel.MAX);
                    case MAX -> setData("Velocità del vento", "5 Km/h", SensorLevel.MIN);
                }
            }
            case HUMIDITY -> {
                switch (level) {
                    case MIN -> setData("Umidità", "20%", SensorLevel.LOW);
                    case LOW -> setData("Umidità", "35%", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Umidità", "50%", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Umidità", "65%", SensorLevel.HIGH);
                    case HIGH -> setData("Umidità", "85%", SensorLevel.MAX);
                    case MAX -> setData("Umidità", "10%", SensorLevel.MIN);
                }
            }
            case AIR_QUALITY -> {
                switch (level) {
                    case MIN -> setData("Qualità dell'aria", "Moderata", SensorLevel.LOW);
                    case LOW -> setData("Qualità dell'aria", "Non Buona", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Qualità dell'aria", "Rischiosa", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Qualità dell'aria", "Dannosa", SensorLevel.HIGH);
                    case HIGH -> setData("Qualità dell'aria", "Pericolosa", SensorLevel.MAX);
                    case MAX -> setData("Qualità dell'aria", "Buona", SensorLevel.MIN);
                }
            }
            case SOIL_PH -> {
                switch (level) {
                    case MIN -> setData("pH del terreno", "4", SensorLevel.LOW);
                    case LOW -> setData("pH del terreno", "5.8", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("pH del terreno", "7.4", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("pH del terreno", "9", SensorLevel.HIGH);
                    case HIGH -> setData("pH del terreno", "12", SensorLevel.MAX);
                    case MAX -> setData("pH del terreno", "2", SensorLevel.MIN);
                }
            }
            case SOIL_TEMPERATURE -> {
                switch (level) {
                    case MIN -> setData("Temperatura suolo", "10°C", SensorLevel.LOW);
                    case LOW -> setData("Temperatura suolo", "15°C", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Temperatura suolo", "20°C", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Temperatura suolo", "30°C", SensorLevel.HIGH);
                    case HIGH -> setData("Temperatura suolo", "40°C", SensorLevel.MAX);
                    case MAX -> setData("Temperatura suolo", "5°C", SensorLevel.MIN);
                }
            }
            case SOIL_NUTRIENTS -> {
                switch (level) {
                    case MIN -> setData("Nutrienti nel suolo", "Scarso", SensorLevel.LOW);
                    case LOW -> setData("Nutrienti nel suolo", "Buono", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Nutrienti nel suolo", "Buono", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Nutrienti nel suolo", "Ottimo", SensorLevel.HIGH);
                    case HIGH -> setData("Nutrienti nel suolo", "Elevato", SensorLevel.MAX);
                    case MAX -> setData("Nutrienti nel suolo", "Scarso", SensorLevel.MIN);
                }
            }
            case SOIL_HUMIDITY -> {
                switch (level) {
                    case MIN -> setData("Umidità del suolo", "Scarsa", SensorLevel.LOW);
                    case LOW -> setData("Umidità del suolo", "Buona", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Umidità del suolo", "Buona", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Umidità del suolo", "Ottima", SensorLevel.HIGH);
                    case HIGH -> setData("Umidità del suolo", "Elevata", SensorLevel.MAX);
                    case MAX -> setData("Umidità del suolo", "Scarsa", SensorLevel.MIN);
                }
            }
            case CO2_CONCENTRATION -> {
                switch (level) {
                    case MIN -> setData("Concentrazione CO2", "Scarsa", SensorLevel.LOW);
                    case LOW -> setData("Concentrazione CO2", "Buona", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Concentrazione CO2", "Buona", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Concentrazione CO2", "Ottima", SensorLevel.HIGH);
                    case HIGH -> setData("Concentrazione CO2", "Elevata", SensorLevel.MAX);
                    case MAX -> setData("Concentrazione CO2", "Scarsa", SensorLevel.MIN);
                }
            }
            case SUN_EXPOSITION -> {
                switch (level) {
                    case MIN -> setData("Esposizione media", "6h 10min", SensorLevel.LOW);
                    case LOW -> setData("Esposizione media", "7h 31min", SensorLevel.MEDIUM_LOW);
                    case MEDIUM_LOW -> setData("Esposizione media", "8h 23min", SensorLevel.MEDIUM_HIGH);
                    case MEDIUM_HIGH -> setData("Esposizione media", "9h 19min", SensorLevel.HIGH);
                    case HIGH -> setData("Esposizione media", "10h 45min", SensorLevel.MAX);
                    case MAX -> setData("Esposizione media", "13h 22min", SensorLevel.MIN);
                }
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void setListener(Listener l) {
        listeners.add(l);
    }

    @Override
    public void removeListener(Listener l) {
        listeners.remove(l);
    }

    @Override
    public void notifyListeners() {
        for (Listener l: listeners) {
            l.onEvent();
        }
    }
}
