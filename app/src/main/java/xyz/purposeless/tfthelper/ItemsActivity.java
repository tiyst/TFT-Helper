package xyz.purposeless.tfthelper;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import xyz.purposeless.tfthelper.Items.ItemBasicFragment;
import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.Items.TFTItemEnum;

public class ItemsActivity extends AppCompatActivity implements ItemBasicFragment.TFTItemListener {

	private static final String TAG = "ItemsActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_items);
		fillWithItems();
	}



	public void fillWithItems() {
		LinearLayout grid = findViewById(R.id.itemsChoosingLayout);

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		/*for (int i = 0; i < TFTItemEnum.values().length; i++) {
			fragmentTransaction.add(grid.getId(), ItemBasicFragment.newInstance("ay?"), "fragment" + i);
			//fragmentTransaction.add(ItemBasicFragment.newInstance("ay?"),"");
			Log.d(TAG, "fillWithItems: " + (i+1));
		}*/

		for (TFTItemBaseEnum item: TFTItemBaseEnum.values()) {
			fragmentTransaction.add(grid.getId(), ItemBasicFragment.newInstance(item.getItemName()), "fragment" + item.getItemName());
			Log.d(TAG, "fillWithItems: " + item.getItemName());
		}
		fragmentTransaction.commit();
	}

	@Override
	public void onItemInteraction(TFTItemEnum item) {
		Log.d(TAG, "Item name: " + item.getItemName() +
				"\nItem desc: " + item.getItemDescription());
	}
}
