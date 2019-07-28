package xyz.purposeless.tfthelper;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

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
		// TODO
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
			ArrayList<TFTItemBaseEnum> previousItems = (ArrayList<TFTItemBaseEnum>) inventoryItems.clone();
			inventoryItems.add(item);
			addInventoryFragment(item);
			processResultItems(previousItems);
		}

		void removeItemFromInventory(String itemName) {
			ArrayList<TFTItemBaseEnum> previousItems = (ArrayList<TFTItemBaseEnum>) inventoryItems.clone();
			TFTItemBaseEnum item = TFTItemBaseEnum.fromString(itemName);
			inventoryItems.remove(item);
			removeInventoryFragment(item);
			processResultItems(previousItems);
		}

		void processResultItems(ArrayList<TFTItemBaseEnum> previousItems) {
			ArrayList<TFTItemBaseEnum> currentItems = (ArrayList<TFTItemBaseEnum>) inventoryItems.clone();
			if (currentItems.size() > previousItems.size()) {
				currentItems.removeAll(previousItems);
				if (currentItems.size() == 1) {
					addCombinedItems(currentItems.get(0));
				} else {
					throw new SecurityException(TAG + "More than one item added a.k.a FIX YOUR SHIT");
				}
			} else {
				previousItems.removeAll(currentItems);
				if (previousItems.size() == 1) {
					removeCombinedItems(previousItems.get(0));
				} else {
					throw new SecurityException(TAG + "More than one item added a.k.a FIX YOUR SHIT");
				}
			}
		}

		void removeCombinedItems(TFTItemBaseEnum removedItem) {
			ArrayList<TFTItemEnum> toBeRemoved = new ArrayList<>();
			for (TFTItemEnum item : resultItems) {
				if (item.isMadeOf(removedItem) && !inventoryItems.contains(removedItem)) {
					toBeRemoved.add(item);
				}
			}
			for (TFTItemEnum item : toBeRemoved) {
				removeResultFragment(item);
			}
		}

		void addCombinedItems(TFTItemBaseEnum addedItem) {
			ArrayList<TFTItemEnum> toBeAdded = new ArrayList<>();
			TFTItemEnum combinedItem;
			for (TFTItemBaseEnum item : inventoryItems) {
				combinedItem = TFTItemEnum.combineBaseItems(addedItem,item);
				if (!resultItems.contains(combinedItem)) {
					toBeAdded.add(combinedItem);
				}
			}
			for (TFTItemEnum item : toBeAdded) {
				addResultFragment(item);
			}
		}

		private void addResultFragment(TFTItemEnum item) {
			resultItems.add(item);
			FragmentTransaction fManager = getSupportFragmentManager().beginTransaction();
			TFTItemBaseEnum[] baseItems = item.getBaseItems();
			fManager.add(R.id.itemsResultLayout,
					ItemCombinedFragment.newInstance(baseItems[0], baseItems[1]),
					item.getItemName());
			fManager.commitNow();
		}

		private void removeResultFragment(TFTItemEnum item) {
			FragmentTransaction fManager = getSupportFragmentManager().beginTransaction();
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
