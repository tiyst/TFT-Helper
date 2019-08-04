package xyz.purposeless.tfthelper.Champions.ChampionGUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.ChampionAttribute;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionAttributeFragment extends Fragment {
    private static final String ARG_ORIGIN = "originParam";

    private ChampionAttribute attribute;
    HexagonMaskView hexImage;


    public ChampionAttributeFragment() {
        // Required empty public constructor
    }

    public static ChampionAttributeFragment newInstance(String originName) {
        ChampionAttributeFragment fragment = new ChampionAttributeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ORIGIN, originName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            attribute = ChampionAttribute.fromString(getArguments().getString(ARG_ORIGIN));
            /*if (attribute == null) { //FIXME
                attribute = ChampionClass.fromString(getArguments().getString(ARG_ORIGIN));
            }*/
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
        hexImage.setImageResource(attribute.getIconID());

        super.onViewCreated(view, savedInstanceState);
    }

    public void makeNotFull() {
        hexImage.setImageAlpha(127);
    }

    public void makeFull() {
        hexImage.setImageAlpha(0);
    }
}
