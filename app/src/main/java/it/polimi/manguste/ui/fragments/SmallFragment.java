package it.polimi.manguste.ui.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

import it.polimi.manguste.R;
import it.polimi.manguste.ui.dashboard.SensorLevel;
import it.polimi.manguste.ui.dashboard.SensorType;

public class SmallFragment extends Fragment {
    // Attributes
    private SensorType type;
    private TextView titleTxt;
    private ImageView icon;
    private TextView descriptionTxt;

    private SmallFragmentViewModel viewModel;

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

        setup();
    }

    public void setup() {
        SensorType temp = null;
        if (null != type) {
            temp = type;
        } else if (null != viewModel.getType().getValue()) {
            temp = viewModel.getType().getValue();
        }
        if (null != temp) {
            switch (temp) {
                case WEATHER -> setData("24°C", "Max: 25°C, Min: 11°C", SensorLevel.MEDIUM_HIGH);
                case COUNTDOWN -> setData("Conto alla rovescia", "-5 giorni", SensorLevel.HIGH);
                case WIND_SPEED -> setData("Velocità del vento", "5 Km/h", SensorLevel.HIGH);
                case HUMIDITY -> setData("Umidità", "56%", SensorLevel.HIGH);
                case AIR_QUALITY -> setData("Qualità dell'aria", "Moderata", SensorLevel.HIGH);
                case SOIL_PH -> setData("pH del terreno", "7.4", SensorLevel.MEDIUM_HIGH);
                case SOIL_TEMPERATURE -> setData("Temperatura suolo", "20°C", SensorLevel.HIGH);
                case SOIL_NUTRIENTS -> setData("Nutrienti nel suolo", "Ottimo", SensorLevel.HIGH);
                case SOIL_HUMIDITY -> setData("Umidità del suolo", "Ottima", SensorLevel.HIGH);
                case CO2_CONCENTRATION -> setData("Concentrazione CO2", "Ottima", SensorLevel.HIGH);
                case SUN_EXPOSITION -> setData("Esposizione media", "8h 23min", SensorLevel.MAX);
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
