package xyz.purposeless.tfthelper;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import xyz.purposeless.tfthelper.Items.InventoryItemFragment;
import xyz.purposeless.tfthelper.Items.ItemBaseFragment;
import xyz.purposeless.tfthelper.Items.ItemCombinedFragment;
import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.Items.TFTItemEnum;

public class ItemsActivity extends AppCompatActivity implements ItemBaseFragment.TFTItemListener
		,ItemCombinedFragment.CombinedItemInteractionListener
		,InventoryItemFragment.OnInventoryItemInteractionListener {

	private static final String TAG = "ItemsActivity";
	private static List<TFTItemBaseEnum> inventoryItems;
	private static List<TFTItemEnum> combinedItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_items);
		inventoryItems = new ArrayList<>();
		combinedItems = new ArrayList<>();
		initBaseItems();
	}

	public void initBaseItems() {
		LinearLayout layout = findViewById(R.id.itemsChoosingLayout);

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		for (TFTItemBaseEnum item: TFTItemBaseEnum.values()) {
			fragmentTransaction.add(layout.getId(), ItemBaseFragment.newInstance(item.getItemName()), "fragment" + item.getItemName());
			Log.d(TAG, "initBaseItems: " + item.getItemName());
		}
		fragmentTransaction.commitNow();
		drawPossibleCombinations();
	}

	@Override
	public void onBaseItemInteraction(TFTItemBaseEnum item) {
//		Log.d(TAG, "Item name: " + item.getItemName() +  //debug
//				"\nItem desc: " + item.getItemDescription());

		inventoryItems.add(item);
		getSupportFragmentManager().beginTransaction() //TAG
				.add(R.id.itemInventory, InventoryItemFragment.newInstance(item.getItemName()), item.getItemName())
				.commitNow();
		Log.d(TAG, "Base item added: " + item.getItemName());
		inventoryItems.add(item);
		drawPossibleCombinations();
	}

	@Override
	public void onCombinedItemTouch(TFTItemBaseEnum item1, TFTItemBaseEnum item2) {
		//TODO remove used items from inventory
	}

	private void drawPossibleCombinations() {
		List<TFTItemEnum> items = getPossibleItemCombinations();

		for (TFTItemEnum item : items) {
			if (!combinedItems.contains(item)) {
				combinedItems.add(item);
				getSupportFragmentManager().beginTransaction() //adding fragment to inventory holder
						.add(R.id.itemsResultLayout, ItemCombinedFragment.newInstance(item.getBaseItems()), item.getItemName())
						.commitNow();
				Log.d(TAG, "Result item fragment added with tag: " + item.getItemName());
			}
		}
	}
	private List<TFTItemEnum> getPossibleItemCombinations() {
		ArrayList<TFTItemEnum> combinedItems = new ArrayList<>();
		TFTItemEnum resultItem;
		for (int i = 0; i < inventoryItems.size(); i++) {
			for (int j = i+1; j < inventoryItems.size(); j++){
				resultItem = TFTItemEnum.combineBaseItems(inventoryItems.get(i), inventoryItems.get(j));
				if (resultItem != null) {
					combinedItems.add(resultItem);
				}
			}
		}

		return combinedItems;
	}

	@Override
	public void onInventoryItemInteraction(String itemName) {
		InventoryItemFragment f = (InventoryItemFragment) getSupportFragmentManager().findFragmentByTag(itemName);
		//Fragment f = getFragmentManager().findFragmentByTag(itemName);
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		if(f!=null) {
			inventoryItems.remove(f.getItem());
			transaction.remove(f);
		} else {
			Log.d(TAG, "onInventoryItemInteraction: no inventory item fragment found: " + itemName);
		}
		transaction.commit();
	}
}
