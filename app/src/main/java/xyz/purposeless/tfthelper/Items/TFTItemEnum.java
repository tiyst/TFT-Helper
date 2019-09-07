package xyz.purposeless.tfthelper.Items;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyz.purposeless.tfthelper.MainActivity;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.Exception.TFTRuntimeException;

import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.BFSword;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.ChainVest;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.GiantsBelt;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.NLRod;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.NegatronCloak;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.RecurveBow;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.SparringGloves;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.Spatula;
import static xyz.purposeless.tfthelper.Items.TFTItemBaseEnum.TearOfGoddess;

public enum TFTItemEnum {
	LordsEdge(R.drawable.itemcombined_lordsedge, R.string.lorgsEdge, R.string.lorgsEdgeDesc, new TFTItemBaseEnum[] {BFSword,BFSword}),
	HextechGunblade(R.drawable.itemcombined_hextechgunblade, R.string.hextechGunblade, R.string.hextechGunbladeDesc, new TFTItemBaseEnum[] {BFSword,NLRod}),
	SwordOfTheDivine(R.drawable.itemcombined_sworddivine, R.string.swordOfDivine, R.string.swordOfDivineDesc, new TFTItemBaseEnum[] {BFSword,RecurveBow}),
	LastWhisper(R.drawable.itemcombined_lastwhisper, R.string.lastWhisper, R.string.lastWhisperDesc, new TFTItemBaseEnum[] {BFSword,RecurveBow}),
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

	RapidfireCannon(R.drawable.itemcombined_rapidfirecannon, R.string.rapidfireCannon, R.string.rapidfireCannonDesc, new TFTItemBaseEnum[] {RecurveBow,RecurveBow}),
	StatikkShiv(R.drawable.itemcombined_statikkshiv, R.string.statikkShiv, R.string.statikkShivDesc, new TFTItemBaseEnum[] {RecurveBow,TearOfGoddess}),
	PhantomDancer(R.drawable.itemcombined_phantomdancer, R.string.phantomDancer, R.string.phantomDancerDesc, new TFTItemBaseEnum[] {RecurveBow,ChainVest}),
	CursedBlade(R.drawable.itemcombined_cursedblade, R.string.cursedBlade, R.string.cursedBladeDesc, new TFTItemBaseEnum[] {RecurveBow,NegatronCloak}),
	TitanicHydra(R.drawable.itemcombined_titanichydra, R.string.titanicHydra, R.string.titanicHydraDesc, new TFTItemBaseEnum[] {RecurveBow,GiantsBelt}),
	BladeRuinedKing(R.drawable.itemcombined_botrk, R.string.botrk, R.string.botrkDesc, new TFTItemBaseEnum[] {RecurveBow,Spatula}),

	SeraphsEmbrace(R.drawable.itemcombined_seraphsembrace, R.string.seraphsEmbrace, R.string.seraphsEmbraceDesc, new TFTItemBaseEnum[] {TearOfGoddess,TearOfGoddess}),
	FrozenHeart(R.drawable.itemcombined_frozenheart, R.string.frozenHeart, R.string.frozenHeartDesc, new TFTItemBaseEnum[] {TearOfGoddess,ChainVest}),
	Hush(R.drawable.itemcombined_hush, R.string.hush, R.string.hushDesc, new TFTItemBaseEnum[] {TearOfGoddess,NegatronCloak}),
	Redemption(R.drawable.itemcombined_redemption, R.string.redemption, R.string.redemptionDesc, new TFTItemBaseEnum[] {TearOfGoddess,GiantsBelt}),
	Darkin(R.drawable.itemcombined_darkin, R.string.darkin, R.string.darkinDesc, new TFTItemBaseEnum[] {TearOfGoddess,Spatula}),

	Thornmail(R.drawable.itemcombined_thornmail, R.string.thornmail, R.string.thornmailDesc, new TFTItemBaseEnum[] {ChainVest,ChainVest}),
	Swordbreaker(R.drawable.itemcombined_swordbreaker, R.string.swordbreaker, R.string.swordbreakerDesc, new TFTItemBaseEnum[] {ChainVest,NegatronCloak}),
	RedBuff(R.drawable.itemcombined_redbuff, R.string.redBuff, R.string.redBuffDesc, new TFTItemBaseEnum[] {ChainVest,GiantsBelt}),
	KnightsVow(R.drawable.itemcombined_knightsvow, R.string.knightsVow, R.string.knightsVowDesc, new TFTItemBaseEnum[] {ChainVest,Spatula}),

	DragonsClaw(R.drawable.itemcombined_dragonsclaw, R.string.dragonsClaw, R.string.dragonsClawDesc, new TFTItemBaseEnum[] {NegatronCloak,NegatronCloak}),
	Zephyr(R.drawable.itemcombined_zephyr, R.string.zephyr, R.string.zephyrDesc, new TFTItemBaseEnum[] {NegatronCloak,GiantsBelt}),
	RunaansHurricane(R.drawable.itemcombined_runaanshurricane, R.string.runaansHurricane, R.string.runaansHurricaneDesc, new TFTItemBaseEnum[] {NegatronCloak,Spatula}),

	WarmogsArmor(R.drawable.itemcombined_warmogs, R.string.warmogs, R.string.warmogsDesc, new TFTItemBaseEnum[] {GiantsBelt,GiantsBelt}),
	FrozenMallet(R.drawable.itemcombined_frozenmallet, R.string.frozenMallet, R.string.frozenMalletDesc, new TFTItemBaseEnum[] {GiantsBelt,Spatula}),

	ForceOfNature(R.drawable.itemcombined_fon, R.string.forceOfNature, R.string.forceOfNatureDesc, new TFTItemBaseEnum[] {Spatula,Spatula}),

	ThiefsGloves(R.drawable.itemcombined_thiefsgloves, R.string.thiefsGloves, R.string.thiefsGlovesDesc, new TFTItemBaseEnum[] {SparringGloves, SparringGloves}),
	HandOfJustice(R.drawable.itemcombined_handofjustice, R.string.handOfJustice, R.string.handOfJusticeDesc, new TFTItemBaseEnum[] {SparringGloves,TearOfGoddess}),
	InfinityEdge(R.drawable.itemcombined_inifinityedge, R.string.infinityEdge, R.string.infinityEdgeDesc, new TFTItemBaseEnum[] {SparringGloves, BFSword}),
	ArcaneGauntlet(R.drawable.itemcombined_arcanegauntlet, R.string.arcaneGauntlet, R.string.arcaneGauntletDesc, new TFTItemBaseEnum[] {SparringGloves,NLRod}),
	Quicksilver(R.drawable.itemcombined_quicksilver, R.string.quicksilver, R.string.quicksilverDesc, new TFTItemBaseEnum[] {SparringGloves, NegatronCloak}),
	IceborneGauntlet(R.drawable.itemcombined_icebornegauntlet, R.string.iceborneGauntlet, R.string.iceborneGauntletDesc, new TFTItemBaseEnum[] {SparringGloves, ChainVest}),
	Backhand(R.drawable.itemcombined_backhand, R.string.backhand, R.string.backhandDesc, new TFTItemBaseEnum[] {SparringGloves, GiantsBelt}),
	RepeatingCrossbow(R.drawable.itemcombined_repeatingcrossbow, R.string.repeatingCrossbow, R.string.repeatingCrossbowDesc, new TFTItemBaseEnum[] {SparringGloves, RecurveBow}),
	Mittens(R.drawable.itemcombined_mittens, R.string.mittens, R.string.mittensDesc, new TFTItemBaseEnum[] {SparringGloves, Spatula});


	private static final String TAG = "TFTItemEnum";

	private int mItemImage;
	private String mItemName;
	private String mItemDescription;
	private TFTItemBaseEnum[] mBaseItems;

	private Context context = MainActivity.getContext();


	TFTItemEnum(int itemImageID, int itemNameID, int itemDescID, TFTItemBaseEnum[] mBaseItems) {
		this.mItemImage = itemImageID;

		this.mItemName = context.getString(itemNameID); //itemName;
		this.mItemDescription = context.getString(itemDescID); //itemDescription;
		this.mBaseItems = mBaseItems;
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


	public static TFTItemEnum fromString(String text) {
		for (TFTItemEnum item : TFTItemEnum.values()) {
			if (item.getItemName().equals(text)) {
				return item;
			}
		}
		throw new TFTRuntimeException("Item " + text + " not found\ncode: TIE");
	}

	public static TFTItemEnum combineBaseItems(TFTItemBaseEnum item1, TFTItemBaseEnum item2) {
		TFTItemBaseEnum[] placeholderBase;
		for (TFTItemEnum item : TFTItemEnum.values()) {
			placeholderBase = item.getBaseItems();
			if ((item1 == placeholderBase[0] && item2 == placeholderBase[1])
			|| (item2 == placeholderBase[0] && item1 == placeholderBase[1])) {
				return item;
			}
		}
		throw new TFTRuntimeException("items can't be combined:\n" + item1.getItemName() + "\n" + item2.toString());
	}

	public boolean isMadeOf(TFTItemBaseEnum item) {
		return (this.mBaseItems[0] == item || this.mBaseItems[1] == item);
	}

	public static List<TFTItemEnum> getActualValues() {
		List<TFTItemEnum> usedItems = new ArrayList<>(Arrays.asList(TFTItemEnum.values()));

		usedItems.remove(SwordOfTheDivine);
		//TODO Used to keep up with patches
		return usedItems;
	}
}
