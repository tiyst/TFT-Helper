package xyz.purposeless.tfthelper.Items;

import android.content.Context;

import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;

import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.BFSword;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.ChainVest;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.GiantsBelt;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.NLRod;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.NegatronCloak;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.RecurveBow;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.TearOfGoddess;

public enum TFTItemEnum {

	InfinityEdge(R.drawable.itemcombined_inifinityedge, R.string.infinityEdge, R.string.infinityEdgeDesc, new TFTItemBaseEnum[] {BFSword,BFSword}),
	HextechGunblade(R.drawable.itemcombined_hextechgunblade, R.string.hextechGunblade, R.string.hextechGunbladeDesc, new TFTItemBaseEnum[] {BFSword,NLRod}),
	SwordOfTheDivine(R.drawable.itemcombined_sworddivine, R.string.swordOfDivine, R.string.swordOfDivineDesc, new TFTItemBaseEnum[] {BFSword,RecurveBow}),
	SpearOfShojin(R.drawable.itemcombined_spearofshojin, R.string.spearOfShojin, R.string.spearOfShojinDesc, new TFTItemBaseEnum[] {BFSword,TearOfGoddess}),
	GuardianAngel(R.drawable.itemcombined_guardianangel, R.string.guardianAngel, R.string.guardianAngelDesc, new TFTItemBaseEnum[] {BFSword,ChainVest}),
	Bloodthirster(R.drawable.itemcombined_bloodthirster, R.string.bloodthirster, R.string.bloodthirsterDesc, new TFTItemBaseEnum[] {BFSword,NegatronCloak}),
	ZekesHerald(R.drawable.itemcombined_zekesherald, R.string.zekesHerald, R.string.zekesHeraldDesc, new TFTItemBaseEnum[] {BFSword,GiantsBelt}),
	YoumuusGhostblade(R.drawable.itemcombined_youmuus, R.string.youmusGhostblade, R.string.youmuusGhostbladeDesc, new TFTItemBaseEnum[] {BFSword,ChainVest});/*,

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


	private int mItemImage;
	private String mItemName;
	private String mItemDescription;
	private TFTItemBaseEnum[] mParentItems;
	private boolean isCombined;

	private Context context = MainActivity.getContext();


	TFTItemEnum(int itemImageID, int itemNameID, int itemDescID, TFTItemBaseEnum[] mParentItems) {
		this.mItemImage = itemImageID;

		this.mItemName = context.getString(itemNameID);//itemName;
		this.mItemDescription = context.getString(itemDescID);//itemDescription;

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

	public TFTItemBaseEnum[] getParentItems() {
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
