package xyz.purposeless.tfthelper.Champions;

import xyz.purposeless.tfthelper.R;

public enum ChampionClass implements ChampionAttribute {

    ASSASSIN(R.drawable.class_assassin, "Assassin", new int[] {3,6}),
    BLADEMASTER(R.drawable.class_blademaster, "Blademaster", new int[] {3,6}),
    BRAWLER(R.drawable.class_brawler, "Brawler", new int[] {2,4}),
    ELEMENTALIST(R.drawable.class_elementalist, "Elementalist", new int[] {3}),
    GUARDIAN(R.drawable.class_guardian, "Guardian", new int[] {2}),
    GUNSLINGER(R.drawable.class_gunslinger, "Gunslinger", new int[] {2,4}),
    KNIGHT(R.drawable.class_knight, "Knight", new int[] {2,4,6}),
    RANGER(R.drawable.class_ranger, "Ranger", new int[] {2,4}),
    SHAPESHIFTER(R.drawable.class_shapeshifter, "Shapeshifter", new int[] {3}),
    SORCERER(R.drawable.class_sorcerer, "Sorcerer", new int[] {3,6});

    private int iconID;
    private String className;
    private int[] effectRequired;

    ChampionClass(int iconID, String className, int[] effectRequired) {
        this.iconID = iconID;
        this.className = className;
        this.effectRequired = effectRequired;
    }

    public static ChampionAttribute fromString(String className) {
        for (ChampionClass clas : ChampionClass.values()) {
            if (clas.getName().equals(className)) {
                return clas;
            }
        }

        return null;
    }

    @Override
    public int getIconID() {
        return this.iconID;
    }

    @Override
    public String getName() {
        return className;
    }

    @Override
    public int[] getBonusReq() {
        return effectRequired;
    }
}
