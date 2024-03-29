package xyz.purposeless.tfthelper.Champions;

import xyz.purposeless.tfthelper.R;

public enum ChampionClass implements ChampionAttribute {

    ASSASSIN(R.drawable.class_assassin, "Assassin", 3,6,9),
    BLADEMASTER(R.drawable.class_blademaster, "Blademaster", 3,6,9),
    BRAWLER(R.drawable.class_brawler, "Brawler", 2,4),
    ELEMENTALIST(R.drawable.class_elementalist, "Elementalist", 3),
    GUARDIAN(R.drawable.class_guardian, "Guardian", 2),
    GUNSLINGER(R.drawable.class_gunslinger, "Gunslinger", 2,4),
    KNIGHT(R.drawable.class_knight, "Knight", 2,4,6),
    RANGER(R.drawable.class_ranger, "Ranger", 2,4),
    SHAPESHIFTER(R.drawable.class_shapeshifter, "Shapeshifter", 3, 6),
    SORCERER(R.drawable.class_sorcerer, "Sorcerer", 3,6,9);

    private int iconID;
    private String className;
    private int[] effectRequired;

    ChampionClass(int iconID,String className, int... effectRequired) {
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
}
