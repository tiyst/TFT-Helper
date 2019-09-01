package xyz.purposeless.tfthelper.Champions.ChampionGUIElements;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionFragment extends Fragment {
	private static final String TAG = "ChampionFragment: ";
	private static final String ARG_CHAMPION = "championParam";

	private Champion champion;
	private HexagonMaskView imageView;

	private onChampFragmentInteractionListener mListener;

	public ChampionFragment() {
		// Required empty public constructor
	}

	public static ChampionFragment newInstance(Champion champ) {
		return newInstance(champ.getName());
	}

	public static ChampionFragment newInstance(String champName) {
		ChampionFragment fragment = new ChampionFragment();
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
		return inflater.inflate(R.layout.fragment_champion, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		view.setOnClickListener(view1 -> onFragmentPressed());
		imageView = view.findViewById(R.id.championIcon);
		imageView.setImageResource(champion.getChampionImageID());

		super.onViewCreated(view, savedInstanceState);
	}

	public void onFragmentPressed() {
		if (mListener != null) {
			mListener.onChampionInteraction(this.champion);
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof onChampFragmentInteractionListener) {
			mListener = (onChampFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement onChampFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}


	public interface onChampFragmentInteractionListener {
		void onChampionInteraction(Champion champion);
	}
}
