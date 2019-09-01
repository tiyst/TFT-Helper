package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.R;

public class UltimateSpellFragment extends Fragment {
	private static final String ARG_CHAMPION = "param1";

	private Champion championParam;


	public UltimateSpellFragment() {
		// Required empty public constructor
	}

	public static UltimateSpellFragment newInstance(Champion champion) {
		UltimateSpellFragment fragment = new UltimateSpellFragment();
		Bundle args = new Bundle();
		args.putString(ARG_CHAMPION, champion.getName());
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			championParam = Champion.fromString(getArguments().getString(ARG_CHAMPION));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_ultimate_spell, container, false);
	}

}
