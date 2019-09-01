package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.Champions.ChampionAttribute;
import xyz.purposeless.tfthelper.Champions.ChampionGUIElements.ChampionFragment;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionHolderAttributeFragment extends ChampionHolder {

	private static final String ARG_ATTR_PARAM = "attributeParameter";

	private ChampionAttribute championAttribute;
	private HexagonMaskView attributeImage;
	private LinearLayout championHolderLayout;
	private TextView attributeName;

	public ChampionHolderAttributeFragment() {
		// Required empty public constructor
	}

	public static ChampionHolderAttributeFragment newInstance(ChampionAttribute attr) {
		ChampionHolderAttributeFragment fragment = new ChampionHolderAttributeFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ATTR_PARAM, attr.getName());
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

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		this.attributeImage = view.findViewById(R.id.champHolderAttrImage);
		this.attributeName = view.findViewById(R.id.champHolderAttrName);

		this.attributeImage.setImageResource(this.championAttribute.getIconID());
		this.attributeName.setText(this.championAttribute.getName());

		this.championHolderLayout = view.findViewById(R.id.champHolderAttrChampionsLayout);
		this.championHolderLayout.setId(
			getResources().getIdentifier(this.championAttribute.getName(), "id", getContext().getPackageName())
		);
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void fillWithChampions() {
		ArrayList<Champion> champions = Champion.getChampionsByAttribute(this.championAttribute);

		FragmentManager manager = getActivity().getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();

		for (Champion champ : champions) {
			int id = getResources().getIdentifier(this.championAttribute.getName(), "id", getActivity().getPackageName());
			transaction.add(id, ChampionFragment.newInstance(champ));
		}

		transaction.commit();
	}
}
