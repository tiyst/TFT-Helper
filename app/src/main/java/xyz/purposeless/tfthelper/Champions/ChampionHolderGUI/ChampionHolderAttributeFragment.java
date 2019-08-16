package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.purposeless.tfthelper.Champions.ChampionAttribute;
import xyz.purposeless.tfthelper.R;

public class ChampionHolderAttributeFragment extends ChampionHolder {

	private static final String ARG_ATTR_PARAM = "attributeParameter";

	private ChampionAttribute championAttribute;

	public ChampionHolderAttributeFragment() {
		// Required empty public constructor
	}

	public static ChampionHolderAttributeFragment newInstance(String param1, String param2) {
		ChampionHolderAttributeFragment fragment = new ChampionHolderAttributeFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ATTR_PARAM, param1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			String attrName = getArguments().getString(ARG_ATTR_PARAM);
			this.championAttribute = ChampionAttribute.fromString(attrName);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_champion_holder_attribute, container, false);
	}

}
