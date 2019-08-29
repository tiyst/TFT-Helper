package xyz.purposeless.tfthelper.Items;

import android.content.Context;

import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;

public enum TFTItemBaseEnum {
	BFSword(R.drawable.item_bfsword, R.string.bfsword, R.string.bfswordDesc),
	NLRod(R.drawable.item_nlrod, R.string.nlRod, R.string.nlRodDesc),
	RecurveBow(R.drawable.item_bow, R.string.recurveBow, R.string.recurveBowDesc),
	TearOfGoddess(R.drawable.item_tear, R.string.tearGoddess, R.string.tearGoddessDesc),
	ChainVest(R.drawable.item_vest, R.string.chainVest, R.string.chainVestDesc),
	NegatronCloak(R.drawable.item_negatron, R.string.negatronCloak, R.string.negatronCloakDesc),
	GiantsBelt(R.drawable.item_giantsbelt, R.string.giantsBelt, R.string.giantsBeltDesc),
	Spatula(R.drawable.item_spatula, R.string.spatula, R.string.spatulaDesc),
	SparringGloves(R.drawable.item_sparringgloves, R.string.sparringGloves, R.string.sparringGlovesDesc);



	private int mItemImage;
	private String mItemName;
	private String mItemDescription;
	private Context context = MainActivity.getContext();


	TFTItemBaseEnum(int itemImageID, int itemNameID, int itemDescID) {
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
