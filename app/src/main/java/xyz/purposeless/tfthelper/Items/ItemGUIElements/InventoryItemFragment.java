package xyz.purposeless.tfthelper.Items.ItemGUIElements;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.R;

public class InventoryItemFragment extends Fragment {
	private static final String TAG = "InventoryItemFragment";
	private static final String ARG_ITEM1 = "Item1";

	private TFTItemBaseEnum mItem;

	private OnInventoryItemInteractionListener mListener;

	public InventoryItemFragment() {
		// Required empty public constructor
	}

	public TFTItemBaseEnum getItem() {
		return mItem;
	}

	public static InventoryItemFragment newInstance(String itemName) {
		InventoryItemFragment fragment = new InventoryItemFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ITEM1, itemName);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mItem = TFTItemBaseEnum.fromString(getArguments().getString(ARG_ITEM1));
		}
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ImageView image = view.findViewById(R.id.inventoryItemImage);
		image.setImageResource(mItem.getItemImageID());

		image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onInventoryItemPressed();
			}
		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_inventory_item, container, false);
	}

	public void onInventoryItemPressed() {
		if (mListener != null) {
			mListener.onInventoryItemInteraction(mItem.getItemName());
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnInventoryItemInteractionListener) {
			mListener = (OnInventoryItemInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnInventoryItemInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	public interface OnInventoryItemInteractionListener {
		void onInventoryItemInteraction(String itemName);
	}
}
