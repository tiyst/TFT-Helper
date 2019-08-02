package xyz.purposeless.tfthelper.Champions.ChampionGUI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.R;

public class ChampionFragment extends Fragment {
    private static final String TAG = "ChampionFragment: ";
    private static final String ARG_CHAMPION = "championParam";

    private Champion champion;

    private OnFragmentInteractionListener mListener;

    public ChampionFragment() {
        // Required empty public constructor
    }

    public static ChampionFragment newInstance(String param1) {
        ChampionFragment fragment = new ChampionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CHAMPION, param1);
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
        return inflater.inflate(R.layout.fragment_champion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.setOnClickListener(view1 -> onFragmentPressed());
        super.onViewCreated(view, savedInstanceState);
    }

    public void onFragmentPressed() {
        if (mListener != null) {
            mListener.onChampionInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        void onChampionInteraction();
    }
}
