package xyz.purposeless.tfthelper.Items;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TFTItemListener} interface
 * to handle interaction events.
 * Use the {@link ItemBasicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemBasicFragment extends Fragment {
	private static final String TAG = "ItemBasicFragment";
	private static final String ARG_ITEM = "itemParameter";

	private TFTItemEnum tftItem;
	private TFTItemListener mListener;

	private Context context = MainActivity.getContext();


	public ItemBasicFragment() {
		// Required empty public constructor
	}

	public static ItemBasicFragment newInstance(String itemName) {
		ItemBasicFragment fragment = new ItemBasicFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ITEM, itemName);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			tftItem = TFTItemEnum.fromString(getArguments().getString(ARG_ITEM));
		}
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_item, container, false);
	}

	public void clickedFragmentTest(View view) {
		Log.d(TAG, "clickedFragmentTest: ");
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(TFTItemEnum item) {
		if (mListener != null) {
			mListener.onItemInteraction(item);
		}
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//		Drawable d = getResources().getDrawable(tftItem.getItemImageID());
		ImageView imageView = view.findViewById(R.id.itemFragmentImage);
		imageView.setImageResource(tftItem.getItemImageID());

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

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface TFTItemListener {
		void onItemInteraction(TFTItemEnum item);
	}
}
