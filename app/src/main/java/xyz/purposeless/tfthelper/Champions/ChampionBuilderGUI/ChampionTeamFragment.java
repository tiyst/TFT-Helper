package xyz.purposeless.tfthelper.Champions.ChampionBuilderGUI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionTeamFragment extends Fragment {

    private static final String ARG_CHAMPION = "championParameter";
    private static final float NOT_FULL = 0.5f;

    private Champion champion;
    private ownedChampionInteractionListener mListener;
    private HexagonMaskView image;

    public ChampionTeamFragment() {
        // Required empty public constructor
    }

    public static ChampionTeamFragment newInstance(String champName) {
        ChampionTeamFragment fragment = new ChampionTeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CHAMPION, champName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            champion = Champion.fromString(getArguments().getString(ARG_CHAMPION));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_champion_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.setOnClickListener(view1 -> onFragmentPressed(champion));
        image = view.findViewById(R.id.inventoryChampion);
        image.setImageResource(champion.getChampionImageID());

        super.onViewCreated(view, savedInstanceState);
    }

    private void onFragmentPressed(Champion champion) {
        if (mListener != null) {
            mListener.ownedChampionInteraction(champion);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ownedChampionInteractionListener) {
            mListener = (ownedChampionInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ownedChampionInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface ownedChampionInteractionListener {
        void ownedChampionInteraction(Champion champion);
    }
}
