package xyz.purposeless.tfthelper;

import android.media.Image;

public enum TFTItemEnum {
	BFSword(null, "mItemName", "itemDesc", null),
	NLRod(null, "mItemName", "itemDesc", null),
	RecurveBow(null, "mItemName", "itemDesc", null),
	TearOfGoddess(null, "mItemName", "itemDesc", null),
	ChainVest(null, "mItemName", "itemDesc", null),
	NegatronCloak(null, "mItemName", "itemDesc", null),
	GiantsBelt(null, "mItemName", "itemDesc", null),
	Spatula(null, "mItemName", "itemDesc", null),

	InfinityEdge(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,BFSword}),
	HextechGunblade(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,NLRod}),
	SwordOfTheDivine(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,RecurveBow}),
	SpearOfShojin(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,TearOfGoddess}),
	GuardianAngel(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,ChainVest});

	TFTItemEnum(Image itemImage, String mItemName, String itemDescription, TFTItemEnum[] mParentItems) {
		this.mItemImage = itemImage;
		this.mItemName = mItemName;
		this.mItemDescription = itemDescription;
		this.mParentItems = mParentItems;
	}

	private Image mItemImage;
	private String mItemName;
	private String mItemDescription;
	private TFTItemEnum[] mParentItems;

	public Image getItemImage() {
		return mItemImage;
	}

	public String getItemName() {
		return mItemName;
	}

	public String getItemDescription() {
		return mItemDescription;
	}

	public TFTItemEnum[] getParentItems() {
		return mParentItems;
	}
}
