package xyz.purposeless.tfthelper.Champions;

import xyz.purposeless.tfthelper.R;

public enum ChampionOrigin implements ChampionAttribute {

	DEMON(R.drawable.origin_demon, "Demon", 2, 4, 6),
	DRAGON(R.drawable.origin_dragon, "Dragon", 2),
	EXILE(R.drawable.origin_exile, "Exile", 1),
	GLACIAL(R.drawable.origin_glacial, "Glacial", 2, 4, 6),
	HEXTECH(R.drawable.origin_hextech, "Hextech", 2, 4),
	IMPERIAL(R.drawable.origin_imperial, "Imperial", 2, 4),
	NINJA(R.drawable.origin_ninja, "Ninja", 1, 4),
	NOBLE(R.drawable.origin_noble, "Noble", 3, 6),
	PHANTOM(R.drawable.origin_phantom, "Phantom", 2),
	PIRATE(R.drawable.origin_pirate, "Pirate", 3),
	ROBOT(R.drawable.origin_robot, "Robot", 1),
	VOID(R.drawable.origin_void, "Void", 3),
	WILD(R.drawable.origin_wild, "Wild", 2, 4),
	YORDLE(R.drawable.origin_yordle, "Yordle", 3, 6);

	private int iconID;
	private String originName;
	private int[] effectRequired;
	private String[] effects;

	ChampionOrigin(int iconID, String originName, int... requirementNumbers) {
		this.iconID = iconID;
		this.originName = originName;
		this.effectRequired = requirementNumbers;
	}

	@Override
	public int getIconID() {
		return this.iconID;
	}

	@Override
	public String getName() {
		return originName;
	}

	@Override
	public int[] getBonusReq() {
		return effectRequired;
	}

	@Override
	public int getNextRequirement(int current) {
		if (current == effectRequired[effectRequired.length - 1]) {
			return effectRequired[effectRequired.length - 1];
		}

		int nextReq = -1;
		for (int i = effectRequired.length - 1; i >= 0; i--) {
			if (current < effectRequired[i]) {
				nextReq = effectRequired[i];
			}
		}

		return nextReq;
	}

	public static ChampionOrigin fromString(String org) {
		for (ChampionOrigin origin : ChampionOrigin.values()) {
			if (origin.getName().equals(org)) {
				return origin;
			}
		}

		return null;
	}
}
