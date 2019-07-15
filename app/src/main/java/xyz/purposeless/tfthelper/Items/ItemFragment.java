package xyz.purposeless.tfthelper.Items;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.R;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TFTItemListener} interface
 * to handle interaction events.
 * Use the {@link ItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemFragment extends Fragment {
	private static final String TAG = "ItemFragment";
	private static final String ARG_ITEM = "itemParameter";

	private TFTItemEnum mTftItemClassVersion;
	private TFTItemListener mListener;

	private ImageView imageView;


	public ItemFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @return A new instance of fragment ItemFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static ItemFragment newInstance(String param1) {
		ItemFragment fragment = new ItemFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ITEM, param1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			String itemName = getArguments().getString(ARG_ITEM);
			//TODO getItem
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
		imageView = view.findViewById(R.id.itemFragmentImage);
		imageView.setImageResource(R.drawable.ic_launcher_foreground);

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
