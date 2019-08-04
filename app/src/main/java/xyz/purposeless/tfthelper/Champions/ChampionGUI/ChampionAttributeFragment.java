package xyz.purposeless.tfthelper.Champions.ChampionGUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.ChampionOrigin;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class OriginFragment extends Fragment {
    private static final String ARG_ORIGIN = "originParam";

    private ChampionOrigin origin;
    HexagonMaskView hexImage;


    public OriginFragment() {
        // Required empty public constructor
    }

    public static OriginFragment newInstance(String originName) {
        OriginFragment fragment = new OriginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ORIGIN, originName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            origin = ChampionOrigin.fromString(getArguments().getString(ARG_ORIGIN));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_origin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        hexImage = view.findViewById(R.id.originImage);
        hexImage.setImageResource(origin.getIconID());

        super.onViewCreated(view, savedInstanceState);
    }

    public void makeNotFull() {
        hexImage.setImageAlpha(127);
    }

    public void makeFull() {
        hexImage.setImageAlpha(0);
    }
}
