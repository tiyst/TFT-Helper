package xyz.purposeless.tfthelper.Items;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;

public enum TFTItemEnum {
	BFSword(R.drawable.item_bfsword, R.string.bfsword, R.string.bfswordDesc, null),
	NLRod(R.drawable.item_nlrod, R.string.nlRod, R.string.nlRodDesc, null),
	RecurveBow(R.drawable.item_bow, R.string.recurveBow, R.string.recurveBowDesc, null),
	TearOfGoddess(R.drawable.item_tear, R.string.recurveBow, R.string.recurveBowDesc, null),
	ChainVest(R.drawable.item_vest, R.string.chainVest, R.string.chainVestDesc, null),
	NegatronCloak(R.drawable.item_negatron, R.string.negatronCloak, R.string.negatronCloakDesc, null),
	GiantsBelt(R.drawable.item_giantsbelt, R.string.giantsBelt, R.string.giantsBeltDesc, null),
	Spatula(R.drawable.item_spatula, R.string.spatula, R.string.spatulaDesc, null);/*,

	InfinityEdge(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,BFSword}),
	HextechGunblade(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,NLRod}),
	SwordOfTheDivine(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,RecurveBow}),
	SpearOfShojin(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,TearOfGoddess}),
	GuardianAngel(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,ChainVest}),
	Bloodthirster(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,NegatronCloak}),
	ZekesHerald(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,GiantsBelt}),
	YoumuusGhostblade(null, "mItemName", "itemDesc", new TFTItemEnum[] {BFSword,ChainVest}),

	Rabadons(null, "mItemName", "itemDesc", new TFTItemEnum[] {NLRod,NLRod}),
	GuinsooRageblade(null, "mItemName", "itemDesc", new TFTItemEnum[] {NLRod,RecurveBow}),
	LudensEcho(null, "mItemName", "itemDesc", new TFTItemEnum[] {NLRod,TearOfGoddess}),
	LocketOfSolari(null, "mItemName", "itemDesc", new TFTItemEnum[] {NLRod,ChainVest}),
	IonicSpark(null, "mItemName", "itemDesc", new TFTItemEnum[] {NLRod,NegatronCloak}),
	Morellonomicon(null, "mItemName", "itemDesc", new TFTItemEnum[] {NLRod,GiantsBelt}),
	Yuumi(null, "mItemName", "itemDesc", new TFTItemEnum[] {NLRod,Spatula}),

	RapidfireCannon(null, "mItemName", "itemDesc", new TFTItemEnum[] {RecurveBow,RecurveBow}),
	StatikkShiv(null, "mItemName", "itemDesc", new TFTItemEnum[] {RecurveBow,TearOfGoddess}),
	PhantomDancer(null, "mItemName", "itemDesc", new TFTItemEnum[] {RecurveBow,ChainVest}),
	CursedBlade(null, "mItemName", "itemDesc", new TFTItemEnum[] {RecurveBow,NegatronCloak}),
	TitanicHydra(null, "mItemName", "itemDesc", new TFTItemEnum[] {RecurveBow,GiantsBelt}),
	BladeRuinedKing(null, "mItemName", "itemDesc", new TFTItemEnum[] {RecurveBow,Spatula}),

	SeraphsEmbrace(null, "mItemName", "itemDesc", new TFTItemEnum[] {TearOfGoddess,TearOfGoddess}),
	FrozenHeart(null, "mItemName", "itemDesc", new TFTItemEnum[] {TearOfGoddess,ChainVest}),
	Hush(null, "mItemName", "itemDesc", new TFTItemEnum[] {TearOfGoddess,NegatronCloak}),
	Redemption(null, "mItemName", "itemDesc", new TFTItemEnum[] {TearOfGoddess,GiantsBelt}),
	Darkin(null, "mItemName", "itemDesc", new TFTItemEnum[] {TearOfGoddess,Spatula}),

	Thornmail(null, "mItemName", "itemDesc", new TFTItemEnum[] {ChainVest,RecurveBow}),
	Swordbreaker(null, "mItemName", "itemDesc", new TFTItemEnum[] {ChainVest,NegatronCloak}),
	RedBuff(null, "mItemName", "itemDesc", new TFTItemEnum[] {ChainVest,GiantsBelt}),
	KnightsVow(null, "mItemName", "itemDesc", new TFTItemEnum[] {ChainVest,Spatula}),

	DragonsClaw(null, "mItemName", "itemDesc", new TFTItemEnum[] {NegatronCloak,NegatronCloak}),
	Zephyr(null, "mItemName", "itemDesc", new TFTItemEnum[] {NegatronCloak,GiantsBelt}),
	RunaansHurricane(null, "mItemName", "itemDesc", new TFTItemEnum[] {NegatronCloak,Spatula}),

	WarmogsArmor(null, "mItemName", "itemDesc", new TFTItemEnum[] {GiantsBelt,GiantsBelt}),
	FrozenMallet(null, "mItemName", "itemDesc", new TFTItemEnum[] {GiantsBelt,Spatula}),

	ForceOfNature(null, "mItemName", "itemDesc", new TFTItemEnum[] {Spatula,Spatula});*/


//	private ImageView mItemImage;
	private int mItemImage;
	private String mItemName;
	private String mItemDescription;
	private TFTItemEnum[] mParentItems;
	private boolean isCombined;

	private Context context = MainActivity.getContext();


	TFTItemEnum(int itemImageID, int itemNameID, int itemDescID, TFTItemEnum[] mParentItems) {
		this.mItemImage = itemImageID;

		this.mItemName = MainActivity.getContext().getString(itemNameID);//itemName;
		this.mItemDescription = MainActivity.getContext().getString(itemDescID);//itemDescription;

		this.isCombined = (mParentItems != null);
		if (isCombined) {
			this.mParentItems = mParentItems;
		}
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

	public TFTItemEnum[] getParentItems() {
		return mParentItems;
	}

	public boolean isCombined() {
		return isCombined;
	}

	public static TFTItemEnum fromString(String text) {
		for (TFTItemEnum item : TFTItemEnum.values()) {
			if (item.getItemName().equals(text)) {
				return item;
			}
		}
		return null;
	}


}
