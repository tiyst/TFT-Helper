package xyz.purposeless.tfthelper.Items.ItemGUI;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;

public class ItemBaseFragment extends Fragment {
	private static final String TAG = "ItemBaseFragment";
	private static final String ARG_ITEM = "itemParameter";

	private TFTItemBaseEnum tftItem;
	private TFTItemListener mListener;

	private Context context = MainActivity.getContext();


	public ItemBaseFragment() {
		// Required empty public constructor
	}

	public static ItemBaseFragment newInstance(String itemName) {
		ItemBaseFragment fragment = new ItemBaseFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ITEM, itemName);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			tftItem = TFTItemBaseEnum.fromString(getArguments().getString(ARG_ITEM));
		}
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_item, container, false);
	}

	public void onFragmentPressed(TFTItemBaseEnum item) {
		if (mListener != null) {
			mListener.onBaseItemInteraction(item);
		}
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		try {
			//Setting item image to fragment
			ImageView imageView = view.findViewById(R.id.itemBaseFragmentImage);
			imageView.setImageResource(tftItem.getItemImageID());
			view.setOnClickListener(view1 -> onFragmentPressed(tftItem));

			//Setting item text to fragment
			TextView itemName = view.findViewById(R.id.itemBaseFragmentName);
			itemName.setText(tftItem.getItemName());
		} catch (NullPointerException e) {
			Log.d(TAG, "onViewCreated: TftItemEnum not initialized");
		}
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof TFTItemListener) {
			mListener = (TFTItemListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement TFTItemListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	public interface TFTItemListener {
		void onBaseItemInteraction(TFTItemBaseEnum item);
	}
}
