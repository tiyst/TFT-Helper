package xyz.purposeless.tfthelper.Champions.ChampionDividerGUI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.Champions.ChampionGUIElements.ChampionFragment;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionHolderCostFragment extends Fragment {
    private static final String ARG_COST = "param1";

    // TODO: Rename and change types of parameters
    private int championCost;
    private List<Champion> Champions;

    private onChampionHolderCostFragment mListener;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_champion_holder_cost, container, false);
    }

    public void onChampionHolderClick() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
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
        view.setOnClickListener(view1 -> onChampionHolderClick());
        fillWithChampions(view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void fillWithChampions(View view) {
        List<Champion> champions = Champion.getByCost(championCost);
        LinearLayout linearLayout = view.findViewById(R.id.heldChampionsCost);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        for (Champion champ : champions) {
            fragmentTransaction.add(linearLayout.getId(), ChampionFragment.newInstance(champ.getName()));
        }
        fragmentTransaction.commitNow();
    }

    private void addChampionFragment(Champion champion) {

    }

    public interface onChampionHolderCostFragment {
        void onFragmentInteraction();
    }
}
