package xyz.purposeless.tfthelper.Champions.ChampionGUIElements;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.ChampionAttribute;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionAttributeFragment extends Fragment {
    private static final String TAG = "ChampionAttrFragment";
    private static final String ARG_ORIGIN = "originParam";
    public static final float ALPHA_FULL  = 1.00f;
    public static final float ALPHA_NOTFULL  = 1.00f;

    private ChampionAttribute attribute;
    private HexagonMaskView hexImage;
    private HexagonMaskView colorMask;
    private boolean isGolden = false;


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
        /*colorMask = view.findViewById(R.id.colorMask);
        colorMask.setAlpha(0.5f);*/

        super.onViewCreated(view, savedInstanceState);
    }

    public void makeNotFull() {
        hexImage.setImageAlpha(127);
    }

    public void makeFull() {
        hexImage.setImageAlpha(0);
    }

    public boolean isGolden() {
        return isGolden;
    }

    public void setGolden(boolean golden) {
        Log.d(TAG, "setGolden: " + golden);
        this.hexImage.setAlpha(ALPHA_FULL);
        this.isGolden = golden;
        processGolden();
    }

    private void processGolden() {
        if (this.isGolden) {
//            hexImage.setColorFilter(ContextCompat.getColor(context, R.color.COLOR_YOUR_COLOR), android.graphics.PorterDuff.Mode.MULTIPLY);
            hexImage.setColorFilter(getResources().getColor(R.color.attrColorGolden), android.graphics.PorterDuff.Mode.MULTIPLY);
        } else {
            hexImage.setColorFilter(getResources().getColor(R.color.attrColorNotGolden), android.graphics.PorterDuff.Mode.MULTIPLY);
        }
    }

    public void setImageAlpha(float value) {
        hexImage.setAlpha(value);
    }
}
