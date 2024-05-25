package it.polimi.manguste.ui.analysis;

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

import it.polimi.manguste.R;
import it.polimi.manguste.databinding.FragmentAnalysisBinding;

public class AnalysisFragment extends Fragment {

private FragmentAnalysisBinding binding;

private ImageView analysis_countdown;
private ImageView humidity_analysis;
private ImageView soil_analysis;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        AnalysisViewModel analysisViewModel =
                new ViewModelProvider(this).get(AnalysisViewModel.class);

        binding = FragmentAnalysisBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        analysis_countdown = requireView().findViewById(R.id.analysis_countdown);
        humidity_analysis = requireView().findViewById(R.id.humidity_analysis);
        soil_analysis = requireView().findViewById(R.id.soil_analysis);

        if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
            // Dark Theme
            analysis_countdown.setImageResource(R.drawable.analysis_countdown_dark);
            humidity_analysis.setImageResource(R.drawable.humidity_analysis_dark);
            soil_analysis.setImageResource(R.drawable.soil_analysis_dark);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}