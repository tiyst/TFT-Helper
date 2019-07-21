package xyz.purposeless.tfthelper.Items;

import android.content.Context;
import android.util.Log;

import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;

import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.BFSword;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.ChainVest;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.GiantsBelt;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.NLRod;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.NegatronCloak;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.RecurveBow;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.Spatula;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.TearOfGoddess;

public enum TFTItemEnum {
	InfinityEdge(R.drawable.itemcombined_inifinityedge, R.string.infinityEdge, R.string.infinityEdgeDesc, new TFTItemBaseEnum[] {BFSword,BFSword}),
	HextechGunblade(R.drawable.itemcombined_hextechgunblade, R.string.hextechGunblade, R.string.hextechGunbladeDesc, new TFTItemBaseEnum[] {BFSword,NLRod}),
	SwordOfTheDivine(R.drawable.itemcombined_sworddivine, R.string.swordOfDivine, R.string.swordOfDivineDesc, new TFTItemBaseEnum[] {BFSword,RecurveBow}),
	SpearOfShojin(R.drawable.itemcombined_spearofshojin, R.string.spearOfShojin, R.string.spearOfShojinDesc, new TFTItemBaseEnum[] {BFSword,TearOfGoddess}),
	GuardianAngel(R.drawable.itemcombined_guardianangel, R.string.guardianAngel, R.string.guardianAngelDesc, new TFTItemBaseEnum[] {BFSword,ChainVest}),
	Bloodthirster(R.drawable.itemcombined_bloodthirster, R.string.bloodthirster, R.string.bloodthirsterDesc, new TFTItemBaseEnum[] {BFSword,NegatronCloak}),
	ZekesHerald(R.drawable.itemcombined_zekesherald, R.string.zekesHerald, R.string.zekesHeraldDesc, new TFTItemBaseEnum[] {BFSword,GiantsBelt}),
	YoumuusGhostblade(R.drawable.itemcombined_youmuus, R.string.youmusGhostblade, R.string.youmuusGhostbladeDesc, new TFTItemBaseEnum[] {BFSword,Spatula}),

	Rabadons(R.drawable.itemcombined_rabadons, R.string.rabadons, R.string.rabadonsDesc, new TFTItemBaseEnum[] {NLRod,NLRod}),
	GuinsooRageblade(R.drawable.itemcombined_guinsoogunblade, R.string.guinsooRageblade, R.string.guinsooRagebladeDesc, new TFTItemBaseEnum[] {NLRod,RecurveBow}),
	LudensEcho(R.drawable.itemcombined_ludensecho, R.string.ludensEcho, R.string.ludensEchoDesc, new TFTItemBaseEnum[] {NLRod,TearOfGoddess}),
	LocketOfSolari(R.drawable.itemcombined_locket, R.string.locketOfSolari, R.string.locketOfSolariDesc, new TFTItemBaseEnum[] {NLRod,ChainVest}),
	IonicSpark(R.drawable.itemcombined_ionicspark, R.string.ionicSpark, R.string.ionicSparkDesc, new TFTItemBaseEnum[] {NLRod,NegatronCloak}),
	Morellonomicon(R.drawable.itemcombined_morello, R.string.morellonomicon, R.string.morellonomiconDesc, new TFTItemBaseEnum[] {NLRod,GiantsBelt}),
	Yuumi(R.drawable.itemcombined_yuumi, R.string.yuumi, R.string.yuumiDesc, new TFTItemBaseEnum[] {NLRod,Spatula}),

	RapidfireCannon(R.drawable.itemcombined_rapidfirecannon, "mItemName", "itemDesc", new TFTItemBaseEnum[] {RecurveBow,RecurveBow}),
	StatikkShiv(R.drawable.itemcombined_statikkshiv, "mItemName", "itemDesc", new TFTItemBaseEnum[] {RecurveBow,TearOfGoddess}),
	PhantomDancer(R.drawable.itemcombined_phantomdancer, "mItemName", "itemDesc", new TFTItemBaseEnum[] {RecurveBow,ChainVest}),
	CursedBlade(R.drawable.itemcombined_cursedblade, "mItemName", "itemDesc", new TFTItemBaseEnum[] {RecurveBow,NegatronCloak}),
	TitanicHydra(R.drawable.itemcombined_titanichydra, "mItemName", "itemDesc", new TFTItemBaseEnum[] {RecurveBow,GiantsBelt}),
	BladeRuinedKing(R.drawable.itemcombined_botrk, "mItemName", "itemDesc", new TFTItemBaseEnum[] {RecurveBow,Spatula}),

	SeraphsEmbrace(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {TearOfGoddess,TearOfGoddess}),
	FrozenHeart(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {TearOfGoddess,ChainVest}),
	Hush(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {TearOfGoddess,NegatronCloak}),
	Redemption(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {TearOfGoddess,GiantsBelt}),
	Darkin(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {TearOfGoddess,Spatula}),

	Thornmail(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {ChainVest,RecurveBow}),
	Swordbreaker(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {ChainVest,NegatronCloak}),
	RedBuff(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {ChainVest,GiantsBelt}),
	KnightsVow(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {ChainVest,Spatula}),

	DragonsClaw(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {NegatronCloak,NegatronCloak}),
	Zephyr(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {NegatronCloak,GiantsBelt}),
	RunaansHurricane(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {NegatronCloak,Spatula}),

	WarmogsArmor(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {GiantsBelt,GiantsBelt}),
	FrozenMallet(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {GiantsBelt,Spatula}),

	ForceOfNature(null, "mItemName", "itemDesc", new TFTItemBaseEnum[] {Spatula,Spatula});*/

	private static final String TAG = "TFTItemEnum";

	private int mItemImage;
	private String mItemName;
	private String mItemDescription;
	private TFTItemBaseEnum[] mBaseItems;
	private boolean isCombined;

	private Context context = MainActivity.getContext();


	TFTItemEnum(int itemImageID, int itemNameID, int itemDescID, TFTItemBaseEnum[] mBaseItems) {
		this.mItemImage = itemImageID;

		this.mItemName = context.getString(itemNameID);//itemName;
		this.mItemDescription = context.getString(itemDescID);//itemDescription;

		this.isCombined = (mBaseItems != null);
		if (isCombined) {
			this.mBaseItems = mBaseItems;
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

	public TFTItemBaseEnum[] getBaseItems() {
		return mBaseItems;
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

	public static TFTItemEnum combineBaseItems(TFTItemBaseEnum item1, TFTItemBaseEnum item2) throws Exception {
		TFTItemBaseEnum[] placeholderBase;
		for (TFTItemEnum item : TFTItemEnum.values()) {
			placeholderBase = item.getBaseItems();
			if ((item1 == placeholderBase[0] && item2 == placeholderBase[1])
			|| (item2 == placeholderBase[0] && item1 == placeholderBase[1])) {
				return item;
			}
		}
		Log.e(TAG, "combineBaseItems: ", new Exception("why have you forsaken me?"));
	}

}
