package it.polimi.manguste.ui.shop;

import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

import it.polimi.manguste.R;
import it.polimi.manguste.ui.dashboard.SensorLevel;
import it.polimi.manguste.ui.dashboard.SensorType;
import it.polimi.manguste.ui.fragments.SmallFragmentViewModel;

public class BigFragment extends Fragment {
    // Attributes
    private SensorType type;

    // Title texts
    private TextView titleTxt;
    private TextView maxTxt;
    private TextView minTxt;

    // Big Icon
    private ImageView icon;

    // Bottom week forecast icons
    private ImageView day1Icon;
    private ImageView day2Icon;
    private ImageView day3Icon;
    private ImageView day4Icon;
    private ImageView day5Icon;
    private ImageView day6Icon;
    private ImageView day7Icon;

    // Bottom week forecast temps
    private TextView day1Temp;
    private TextView day2Temp;
    private TextView day3Temp;
    private TextView day4Temp;
    private TextView day5Temp;
    private TextView day6Temp;
    private TextView day7Temp;

    // Bottom week days
    private TextView day1Name;
    private TextView day2Name;
    private TextView day3Name;
    private TextView day4Name;
    private TextView day5Name;
    private TextView day6Name;
    private TextView day7Name;

    private BigFragmentViewModel viewModel;


    // Constructor Method
    public BigFragment() {}

    // Getters and Setters
    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public void setData(String value, String description, SensorLevel level) {
        if (null != type) {
            viewModel.setType(type);
        }
        viewModel.setTitle(value);
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
        }
    }

    // Methods

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO) {
            return inflater.inflate(R.layout.fragment_big_white, container, false);
        } else {
            return inflater.inflate(R.layout.fragment_big_black, container, false);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(BigFragmentViewModel.class);
        viewModel.getTitle().observe(this, title -> {
            titleTxt.setText(title);
        });
        viewModel.getResID().observe(this, resID -> {
            icon.setImageResource(resID);
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Retrieve data and display it here
        bind();
        setDays();

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
                case AIR_QUALITY -> setData("Qualità dell'aria", "Moderata", SensorLevel.LOW);
                case SOIL_PH -> setData("pH del terreno", "7.4", SensorLevel.MEDIUM_HIGH);
                case SOIL_TEMPERATURE -> setData("Temperatura suolo", "20°C", SensorLevel.HIGH);
                case SOIL_NUTRIENTS -> setData("Nutrienti nel suolo", "Ottimo", SensorLevel.HIGH);
                case SOIL_HUMIDITY -> setData("Umidità del suolo", "Ottima", SensorLevel.HIGH);
                case CO2_CONCENTRATION -> setData("Concentrazione CO2", "Ottima", SensorLevel.HIGH);
                case SUN_EXPOSITION -> setData("Esposizione media", "8h 23min", SensorLevel.MAX);
            }
        }
    }

    private void bind() {
        // Title texts
        titleTxt = getView().findViewById(R.id.fragment_title);
        maxTxt = getView().findViewById(R.id.max_temperature);
        minTxt = getView().findViewById(R.id.min_temperature);
        // Big Icon
        icon = getView().findViewById(R.id.fragment_image);
        // Bottom week forecast icons
        day1Icon = getView().findViewById(R.id.weather_icon_1);
        day2Icon = getView().findViewById(R.id.weather_icon_2);
        day3Icon = getView().findViewById(R.id.weather_icon_3);
        day4Icon = getView().findViewById(R.id.weather_icon_4);
        day5Icon = getView().findViewById(R.id.weather_icon_5);
        day6Icon = getView().findViewById(R.id.weather_icon_6);
        day7Icon = getView().findViewById(R.id.weather_icon_7);
        // Bottom week forecast temps
        day1Temp = getView().findViewById(R.id.weather_temp_1);
        day2Temp = getView().findViewById(R.id.weather_temp_2);
        day3Temp = getView().findViewById(R.id.weather_temp_3);
        day4Temp = getView().findViewById(R.id.weather_temp_4);
        day5Temp = getView().findViewById(R.id.weather_temp_5);
        day6Temp = getView().findViewById(R.id.weather_temp_6);
        day7Temp = getView().findViewById(R.id.weather_temp_7);
        // Bottom week days
        day1Name = getView().findViewById(R.id.day_1);
        day2Name = getView().findViewById(R.id.day_2);
        day3Name = getView().findViewById(R.id.day_3);
        day4Name = getView().findViewById(R.id.day_4);
        day5Name = getView().findViewById(R.id.day_5);
        day6Name = getView().findViewById(R.id.day_6);
        day7Name = getView().findViewById(R.id.day_7);
    }

    private void setDays() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        switch (day) {
            case MONDAY -> {
                day1Name.setText(R.string.short_tuesday);
                day2Name.setText(R.string.short_wednesday);
                day3Name.setText(R.string.short_thursday);
                day4Name.setText(R.string.short_friday);
                day5Name.setText(R.string.short_saturday);
                day6Name.setText(R.string.short_sunday);
                day7Name.setText(R.string.short_monday);
            }
            case TUESDAY -> {
                day1Name.setText(R.string.short_wednesday);
                day2Name.setText(R.string.short_thursday);
                day3Name.setText(R.string.short_friday);
                day4Name.setText(R.string.short_saturday);
                day5Name.setText(R.string.short_sunday);
                day6Name.setText(R.string.short_monday);
                day7Name.setText(R.string.short_tuesday);
            }
            case WEDNESDAY -> {
                day1Name.setText(R.string.short_thursday);
                day2Name.setText(R.string.short_friday);
                day3Name.setText(R.string.short_saturday);
                day4Name.setText(R.string.short_sunday);
                day5Name.setText(R.string.short_monday);
                day6Name.setText(R.string.short_tuesday);
                day7Name.setText(R.string.short_wednesday);
            }
            case THURSDAY -> {
                day1Name.setText(R.string.short_friday);
                day2Name.setText(R.string.short_saturday);
                day3Name.setText(R.string.short_sunday);
                day4Name.setText(R.string.short_monday);
                day5Name.setText(R.string.short_tuesday);
                day6Name.setText(R.string.short_wednesday);
                day7Name.setText(R.string.short_thursday);
            }
            case FRIDAY -> {
                day1Name.setText(R.string.short_saturday);
                day2Name.setText(R.string.short_sunday);
                day3Name.setText(R.string.short_monday);
                day4Name.setText(R.string.short_tuesday);
                day5Name.setText(R.string.short_wednesday);
                day6Name.setText(R.string.short_thursday);
                day7Name.setText(R.string.short_friday);
            }
            case SATURDAY -> {
                day1Name.setText(R.string.short_sunday);
                day2Name.setText(R.string.short_monday);
                day3Name.setText(R.string.short_tuesday);
                day4Name.setText(R.string.short_wednesday);
                day5Name.setText(R.string.short_thursday);
                day6Name.setText(R.string.short_friday);
                day7Name.setText(R.string.short_saturday);
            }
            case SUNDAY -> {
                day1Name.setText(R.string.short_monday);
                day2Name.setText(R.string.short_tuesday);
                day3Name.setText(R.string.short_wednesday);
                day4Name.setText(R.string.short_thursday);
                day5Name.setText(R.string.short_friday);
                day6Name.setText(R.string.short_saturday);
                day7Name.setText(R.string.short_sunday);
            }
        }

    }
}