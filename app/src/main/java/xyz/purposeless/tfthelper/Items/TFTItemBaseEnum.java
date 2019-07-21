package xyz.purposeless.tfthelper.Items;

import android.content.Context;

import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;

public enum TFTItemBaseEnum {
	BFSword(R.drawable.item_bfsword, R.string.bfsword, R.string.bfswordDesc, null),
	NLRod(R.drawable.item_nlrod, R.string.nlRod, R.string.nlRodDesc, null),
	RecurveBow(R.drawable.item_bow, R.string.recurveBow, R.string.recurveBowDesc, null),
	TearOfGoddess(R.drawable.item_tear, R.string.tearGoddess, R.string.tearGoddessDesc, null),
	ChainVest(R.drawable.item_vest, R.string.chainVest, R.string.chainVestDesc, null),
	NegatronCloak(R.drawable.item_negatron, R.string.negatronCloak, R.string.negatronCloakDesc, null),
	GiantsBelt(R.drawable.item_giantsbelt, R.string.giantsBelt, R.string.giantsBeltDesc, null),
	Spatula(R.drawable.item_spatula, R.string.spatula, R.string.spatulaDesc, null);



	private int mItemImage;
	private String mItemName;
	private String mItemDescription;
	private Context context = MainActivity.getContext();


	TFTItemBaseEnum(int itemImageID, int itemNameID, int itemDescID, TFTItemEnum[] mParentItems) {
		this.mItemImage = itemImageID;

		this.mItemName = context.getString(itemNameID);//itemName;
		this.mItemDescription = context.getString(itemDescID);//itemDescription;

	}

	public int getItemImageID() {
		return mItemImage;
	}

	public String getItemName() {
		return mItemName;
	}

	public String getItemDescription() {
		return mItemDescription;
	}

	public static TFTItemBaseEnum fromString(String text) {
		for (TFTItemBaseEnum item : TFTItemBaseEnum.values()) {
			if (item.getItemName().equals(text)) {
				return item;
			}
		}
		return null;
	}
}
