package xyz.purposeless.tfthelper;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import xyz.purposeless.tfthelper.Exception.TFTRuntimeException;
import xyz.purposeless.tfthelper.Items.InventoryItemFragment;
import xyz.purposeless.tfthelper.Items.ItemBaseFragment;
import xyz.purposeless.tfthelper.Items.ItemCombinedFragment;
import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.Items.TFTItemEnum;

public class ItemsActivity extends AppCompatActivity implements ItemBaseFragment.TFTItemListener
		,ItemCombinedFragment.CombinedItemInteractionListener
		,InventoryItemFragment.OnInventoryItemInteractionListener {

	private static final String TAG = "ItemsActivity";
	private ItemController itemController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_items);
		itemController = new ItemController();
		drawBaseItems();
	}

	public void drawBaseItems() {
		LinearLayout layout = findViewById(R.id.itemsChoosingLayout);
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		for (TFTItemBaseEnum item: TFTItemBaseEnum.values()) {
			fragmentTransaction.add(layout.getId(), ItemBaseFragment.newInstance(item.getItemName()));
		}
		fragmentTransaction.commitNow();
	}

	@Override
	public void onBaseItemInteraction(TFTItemBaseEnum item) {
		itemController.addItemToInventory(item);
	}

	@Override
	public void onCombinedItemInteraction(TFTItemBaseEnum item1, TFTItemBaseEnum item2) {
		itemController.removeResultItem(TFTItemEnum.combineBaseItems(item1, item2));
	}

	@Override
	public void onInventoryItemInteraction(String itemName) {
		itemController.removeItemFromInventory(itemName);
	}


	private class ItemController {

		private ArrayList<TFTItemBaseEnum> inventoryItems;
		private ArrayList<TFTItemEnum> resultItems;

		ItemController() {
			inventoryItems = new ArrayList<>();
			resultItems = new ArrayList<>();
		}

		void addItemToInventory(TFTItemBaseEnum item) {
			inventoryItems.add(item);
			addInventoryFragment(item);
			resultItemDifferential();
		}

		void removeItemFromInventory(String itemName) {
			TFTItemBaseEnum item = TFTItemBaseEnum.fromString(itemName);
			inventoryItems.remove(item);
			removeInventoryFragment(item);
			resultItemDifferential();
		}

		void removeResultItem(TFTItemEnum item) {
			TFTItemBaseEnum[] baseItems = item.getBaseItems();
			removeItemFromInventory(baseItems[0].getItemName());
			removeItemFromInventory(baseItems[1].getItemName());
			removeResultFragment(item);
		}

		private void resultItemDifferential() {
			ArrayList<TFTItemEnum> possibleItems = new ArrayList<>();
			TFTItemEnum resultItem;
			for (int i = 0; i < inventoryItems.size(); i++) { //Get all possible items from current base items
				for (int j = i+1; j < inventoryItems.size(); j++) {
					resultItem = TFTItemEnum.combineBaseItems(inventoryItems.get(i),inventoryItems.get(j));
					if (!possibleItems.contains(resultItem)) {
						possibleItems.add(resultItem);
					}
				}
			}

			if (resultItems.size() > possibleItems.size()) { //Item has been removed
				ArrayList<TFTItemEnum> itemDifferential = (ArrayList<TFTItemEnum>) resultItems.clone();
				itemDifferential.removeAll(possibleItems);
				for (TFTItemEnum item : itemDifferential) {
					removeResultFragment(item);
				}

			} else { //Items have been added
				possibleItems.removeAll(resultItems);
				for (TFTItemEnum item : possibleItems) {
					addResultFragment(item);
				}
			}
		}

		private void addResultFragment(TFTItemEnum item) {
			if (!resultItems.contains(item)) {
				resultItems.add(item);
				FragmentTransaction fManager = getSupportFragmentManager().beginTransaction();
				TFTItemBaseEnum[] baseItems = item.getBaseItems();
				fManager.add(R.id.itemsResultLayout,
						ItemCombinedFragment.newInstance(baseItems[0], baseItems[1]),
						item.getItemName());
				fManager.commitNow();
			} else {
				throw new TFTRuntimeException("WHAT THE FUCK?!");
			}
		}

		private void removeResultFragment(TFTItemEnum item) {
			ItemCombinedFragment f = (ItemCombinedFragment) getSupportFragmentManager().findFragmentByTag(item.getItemName());
			if(f != null) {
				resultItems.remove(item);
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.remove(f);
				transaction.commitNow();
			}
		}

		private void addInventoryFragment(TFTItemBaseEnum item) {
			FragmentTransaction fManager = getSupportFragmentManager().beginTransaction();
			fManager.add(R.id.itemInventory,
					InventoryItemFragment.newInstance(item.getItemName()),
					item.getItemName());
			fManager.commitNow();
		}

		private void removeInventoryFragment(TFTItemBaseEnum item) {
			InventoryItemFragment f = (InventoryItemFragment) getSupportFragmentManager().findFragmentByTag(item.getItemName());
			if(f != null) {
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.remove(f);
				transaction.commitNow();
			} else {
				Log.d(TAG, "removeInventoryFragment: SOMETHING'S WRONG!!");
			}
		}
	}
}
