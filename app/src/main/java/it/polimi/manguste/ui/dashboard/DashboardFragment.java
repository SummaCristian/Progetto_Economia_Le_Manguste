package it.polimi.manguste.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import it.polimi.manguste.Listener;
import it.polimi.manguste.R;
import it.polimi.manguste.databinding.FragmentDashboardBinding;
import it.polimi.manguste.ui.fragments.SmallFragment;
import it.polimi.manguste.ui.shop.BigFragment;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private BigFragment weatherFragment;
    private SmallFragment countdownFragment;
    private SmallFragment windSpeedFragment;
    private SmallFragment humidityFragment;
    private SmallFragment airQualityFragment;
    private SmallFragment soilPhFragment;
    private SmallFragment soilTemperatureFragment;
    private SmallFragment soilNutrientFragment;
    private SmallFragment soilHumidityFragment;
    private SmallFragment co2ConcentrationFragment;
    private SmallFragment sunExpositionFragment;

    private boolean isEditMode = false;

    private OnBackPressedCallback callback;

    public boolean isEditMode() {
        return isEditMode;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

    binding = FragmentDashboardBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        weatherFragment = new BigFragment();
        weatherFragment.setType(SensorType.WEATHER);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.weather_fragment, weatherFragment)
                .commit();

        countdownFragment = new SmallFragment();
        countdownFragment.setType(SensorType.COUNTDOWN);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.countdown_fragment, countdownFragment)
                .commit();

        windSpeedFragment = new SmallFragment();
        windSpeedFragment.setType(SensorType.WIND_SPEED);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.wind_speed_fragment, windSpeedFragment)
                .commit();

        humidityFragment = new SmallFragment();
        humidityFragment.setType(SensorType.HUMIDITY);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.humidity_fragment, humidityFragment)
                .commit();

        airQualityFragment = new SmallFragment();
        airQualityFragment.setType(SensorType.AIR_QUALITY);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.air_quality_fragment, airQualityFragment)
                .commit();

        soilPhFragment = new SmallFragment();
        soilPhFragment.setType(SensorType.SOIL_PH);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_pH_fragment, soilPhFragment)
                .commit();

        soilTemperatureFragment = new SmallFragment();
        soilTemperatureFragment.setType(SensorType.SOIL_TEMPERATURE);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_temperature_fragment, soilTemperatureFragment)
                .commit();

        soilNutrientFragment = new SmallFragment();
        soilNutrientFragment.setType(SensorType.SOIL_NUTRIENTS);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_nutrient_fragment, soilNutrientFragment)
                .commit();

        soilHumidityFragment = new SmallFragment();
        soilHumidityFragment.setType(SensorType.SOIL_HUMIDITY);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_humidity_fragment, soilHumidityFragment)
                .commit();

        co2ConcentrationFragment = new SmallFragment();
        co2ConcentrationFragment.setType(SensorType.CO2_CONCENTRATION);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.co2_concentration_fragment, co2ConcentrationFragment)
                .commit();

        sunExpositionFragment = new SmallFragment();
        sunExpositionFragment.setType(SensorType.SUN_EXPOSITION);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.sun_exposition_fragment, sunExpositionFragment)
                .commit();

        callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                disableEditMode();
            }
        };
        initLongPress();
        return root;
    }

    private void initLongPress() {
        weatherFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        countdownFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        windSpeedFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        humidityFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        airQualityFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        soilPhFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        soilTemperatureFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        soilNutrientFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        soilHumidityFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        co2ConcentrationFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
        sunExpositionFragment.setListener(new Listener() {
            @Override
            public void onEvent() {
                if (!isEditMode) {
                    enableEditMode();
                }
            }
        });
    }

    private void enableEditMode() {
        isEditMode = true;
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),callback);
        // TODO: Add Weather
        countdownFragment.enableEditMode();
        windSpeedFragment.enableEditMode();
        humidityFragment.enableEditMode();
        airQualityFragment.enableEditMode();
        soilPhFragment.enableEditMode();
        soilTemperatureFragment.enableEditMode();
        soilNutrientFragment.enableEditMode();
        soilHumidityFragment.enableEditMode();
        co2ConcentrationFragment.enableEditMode();
        sunExpositionFragment.enableEditMode();
    }

    private void disableEditMode() {
        isEditMode = false;
        callback.remove();
        // TODO: Add Weather
        countdownFragment.disableEditMode();
        windSpeedFragment.disableEditMode();
        humidityFragment.disableEditMode();
        airQualityFragment.disableEditMode();
        soilPhFragment.disableEditMode();
        soilTemperatureFragment.disableEditMode();
        soilNutrientFragment.disableEditMode();
        soilHumidityFragment.disableEditMode();
        co2ConcentrationFragment.disableEditMode();
        sunExpositionFragment.disableEditMode();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }




@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}