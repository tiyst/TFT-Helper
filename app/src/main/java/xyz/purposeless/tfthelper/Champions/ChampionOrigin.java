package xyz.purposeless.tfthelper.Champions;

import xyz.purposeless.tfthelper.R;

public enum ChampionOrigin implements ChampionAttribute {

    DEMON(R.drawable.origin_demon, "Demon", new int[] {2,4,6}),
    DRAGON(R.drawable.origin_dragon, "Dragon", new int[] {2}),
    EXILE(R.drawable.origin_exile, "Exile", new int[] {1}),
    GLACIAL(R.drawable.origin_glacial, "Glacial", new int[] {2,4,6}),
    IMPERIAL(R.drawable.origin_imperial, "Imperial", new int[] {2,4}),
    NINJA(R.drawable.origin_ninja, "Ninja", new int[] {1,4} ),
    NOBLE(R.drawable.origin_noble, "Noble", new int[] {3,6}),
    PHANTOM(R.drawable.origin_phantom, "Phantom", new int[] {2}),
    PIRATE(R.drawable.origin_pirate, "Pirate", new int[] {3}),
    ROBOT(R.drawable.origin_robot, "Robot", new int[] {1}),
    VOID(R.drawable.origin_void, "Void", new int[] {3}),
    WILD(R.drawable.origin_wild, "Wild", new int[] {2,4}),
    YORDLE(R.drawable.origin_yordle, "Yordle", new int[] {3,6});

    private int iconID;
    private String originName;
    private int[] effectRequired;
    private String[] effects;

    ChampionOrigin(int iconID, String originName, int[] champNums) {
        this.iconID = iconID;
        this.originName = originName;
        this.effectRequired = champNums;
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


    public static ChampionOrigin fromString(String org) {
        for (ChampionOrigin origin : ChampionOrigin.values()) {
            if (origin.getName().equals(org)) {
                return origin;
            }
        }

        return null;
    }
}
