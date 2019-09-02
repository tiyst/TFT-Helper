package xyz.purposeless.tfthelper.Champions.ChampionGUIElements;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.ChampionAttribute;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionAttributeFragment extends Fragment {
    private static final String TAG = "ChampionAttrFragment";
    private static final String ARG_ORIGIN = "originParam";
    public static final float ALPHA_FULL  = 1.00f;
    public static final float ALPHA_NOTFULL  = 0.5f;


    private ChampionAttribute attribute;
    private HexagonMaskView hexImage;
    private TextView currentNumberView;
    private TextView delimeterView;
    private TextView nextNumberView;

    private int current;
    private int nextRequirement;
    private boolean isGolden = false;
    private boolean numbersVisible = true;


    public ChampionAttributeFragment() {
        // Required empty public constructor
    }

    public static ChampionAttributeFragment newInstance(ChampionAttribute attr) {
        return newInstance(attr.getName());

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
        currentNumberView = view.findViewById(R.id.currentNumber);
        delimeterView = view.findViewById(R.id.delimeter);
        nextNumberView = view.findViewById(R.id.nextNumber);

        //In use in champion detail
        if (!numbersVisible) {
            this.currentNumberView.setVisibility(View.INVISIBLE);
            this.nextNumberView.setVisibility(View.INVISIBLE);
            this.delimeterView.setVisibility(View.INVISIBLE);
        }

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
        if (golden) {
            this.hexImage.setAlpha(ALPHA_FULL);
        }
        this.isGolden = golden;
        processGolden();
    }

    private void processGolden() {
        if (this.isGolden) {
            hexImage.setColorFilter(getResources().getColor(R.color.attrColorGolden), android.graphics.PorterDuff.Mode.MULTIPLY);
        } else {
            hexImage.setColorFilter(getResources().getColor(R.color.attrColorNotGolden), android.graphics.PorterDuff.Mode.MULTIPLY);
        }
    }

    public void setImageAlpha(float value) {
        hexImage.setAlpha(value);
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.currentNumberView.setText(String.valueOf(current));
        this.current = current;
    }

    public int getNextRequirement() {
        return nextRequirement;
    }

    public void setNextRequirement(int nextRequirement) {
        this.nextNumberView.setText(String.valueOf(nextRequirement));
        this.nextRequirement = nextRequirement;
    }

    public void setNumbersVisibility(boolean visible) {
        this.numbersVisible = visible;
    }

    public ChampionAttribute getAttribute() {
        return attribute;
    }
}
