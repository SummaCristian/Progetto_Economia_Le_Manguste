package it.polimi.manguste.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import it.polimi.manguste.R;
import it.polimi.manguste.databinding.FragmentDashboardBinding;
import it.polimi.manguste.ui.fragments.SmallFragment;

public class DashboardFragment extends Fragment {

private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

    binding = FragmentDashboardBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        SmallFragment weatherFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.weather_fragment, weatherFragment)
                .commit();

        SmallFragment countdownFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.countdown_fragment, countdownFragment)
                .commit();

        SmallFragment windSpeedFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.wind_speed_fragment, windSpeedFragment)
                .commit();

        SmallFragment humidityFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.humidity_fragment, humidityFragment)
                .commit();

        SmallFragment airQualityFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.air_quality_fragment, airQualityFragment)
                .commit();

        SmallFragment soilPhFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_pH_fragment, soilPhFragment)
                .commit();

        SmallFragment soilTemperatureFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_temperature_fragment, soilTemperatureFragment)
                .commit();

        SmallFragment soilNutrientFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_nutrient_fragment, soilNutrientFragment)
                .commit();

        SmallFragment soilHumidityFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.soil_humidity_fragment, soilHumidityFragment)
                .commit();

        SmallFragment co2ConcentrationFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.co2_concentration_fragment, co2ConcentrationFragment)
                .commit();

        SmallFragment sunExpositionFragment = new SmallFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.sun_exposition_fragment, sunExpositionFragment)
                .commit();


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}