package xyz.purposeless.tfthelper.Items.ItemGUI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.Items.TFTItemEnum;
import xyz.purposeless.tfthelper.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CombinedItemInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ItemCombinedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemCombinedFragment extends Fragment {
	private static final String ARG_ITEM1 = "item1";
	private static final String ARG_ITEM2 = "item2";

	private TFTItemEnum combinedItem;

	private TFTItemBaseEnum mItem1;
	private TFTItemBaseEnum mItem2;

	private CombinedItemInteractionListener mListener;

	public ItemCombinedFragment() {
		// Required empty public constructor
	}

	public static ItemCombinedFragment newInstance(TFTItemBaseEnum item1, TFTItemBaseEnum item2) {
		ItemCombinedFragment fragment = new ItemCombinedFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ITEM1, item1.getItemName());
		args.putString(ARG_ITEM2, item2.getItemName());
		fragment.setArguments(args);
		return fragment;
	}

	public static ItemCombinedFragment newInstance(TFTItemBaseEnum[] items) {
		ItemCombinedFragment fragment = new ItemCombinedFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ITEM1, items[0].getItemName());
		args.putString(ARG_ITEM2, items[1].getItemName());
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		combinedItem = TFTItemEnum.combineBaseItems(mItem1,mItem2);
		ImageView itemImg = view.findViewById(R.id.combinedItemImage);
		TextView itemName = view.findViewById(R.id.combinedItemName);
		TextView itemDesc = view.findViewById(R.id.combinedItemDescription);

		itemImg.setImageResource(combinedItem.getItemImageID());
		itemName.setText(combinedItem.getItemName());
		itemDesc.setText(combinedItem.getItemDescription());

		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onCombinedItemInteraction();
			}
		});

		super.onViewCreated(view, savedInstanceState);


	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		if (getArguments() != null) {
			mItem1 = TFTItemBaseEnum.fromString(args.getString(ARG_ITEM1));
			mItem2 = TFTItemBaseEnum.fromString(args.getString(ARG_ITEM2));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_item_combined, container, false);
	}

	public void onCombinedItemInteraction() {
		if (mListener != null) {
			mListener.onCombinedItemInteraction(mItem1, mItem2);
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof CombinedItemInteractionListener) {
			mListener = (CombinedItemInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement CombinedItemInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	public interface CombinedItemInteractionListener {
		void onCombinedItemInteraction(TFTItemBaseEnum item1, TFTItemBaseEnum item2);
	}
}
