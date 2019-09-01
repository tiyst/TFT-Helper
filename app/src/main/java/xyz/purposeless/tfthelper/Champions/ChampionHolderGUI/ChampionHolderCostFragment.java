package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.Champions.ChampionGUIElements.ChampionFragment;
import xyz.purposeless.tfthelper.R;

public class ChampionHolderCostFragment extends ChampionHolder {
    private static final String TAG = "ChampionHolderCostFrag";
    private static final String ARG_COST = "paramCost";

    private int championCost;

    private onChampionHolderCostFragment mListener;
    private ImageView costImage;
    private TextView costText;
    private LinearLayout championsLayout;

    public ChampionHolderCostFragment() {
        // Required empty public constructor
    }

    public static ChampionHolderCostFragment newInstance(int cost) {
        ChampionHolderCostFragment fragment = new ChampionHolderCostFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COST, cost);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            championCost = getArguments().getInt(ARG_COST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_champion_holder_cost, container, false);
    }

    public void onChampionHolderClick() {
        if (mListener != null) {
            mListener.onChampionHolderCostFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onChampionHolderCostFragment) {
            mListener = (onChampionHolderCostFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onChampionHolderCostFragment");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.costImage = view.findViewById(R.id.championHolderCostImage);
        this.costText = view.findViewById(R.id.championHolderCost);
        this.championsLayout = view.findViewById(R.id.heldChampionsCost);
        this.championsLayout.setId(this.championCost);

        view.setOnClickListener(view1 -> onChampionHolderClick());
        setCostIcon();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void fillWithChampions() {
        List<Champion> champions = Champion.getByCost(championCost);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Log.d(TAG, "fillWithChampions: adding champions to id " + this.championsLayout.getId());
        for (Champion champ : champions) {
            fragmentTransaction.add(this.championCost, ChampionFragment.newInstance(champ.getName()));
        }
        fragmentTransaction.commitNow();
    }

    public interface onChampionHolderCostFragment {
        void onChampionHolderCostFragmentInteraction();
    }

    private void setCostIcon() {
        this.costText.setText(this.championCost + " gold");
        switch (this.championCost) {
            case 1: this.costImage.setImageAlpha(0); //transparent (no icon)
                break;
            case 2: this.costImage.setImageResource(R.drawable.tier2);
                break;
            case 3: this.costImage.setImageResource(R.drawable.tier3);
                break;
            case 4: this.costImage.setImageResource(R.drawable.tier4);
                break;
            case 5: this.costImage.setImageResource(R.drawable.tier5);
                break;

            default:
                Log.d(TAG, "setCostIcon: wrong champion cost" + this.championCost);
        }
    }
}
