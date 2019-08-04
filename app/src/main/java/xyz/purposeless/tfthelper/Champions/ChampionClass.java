package xyz.purposeless.tfthelper.Champions;

import xyz.purposeless.tfthelper.R;

public enum ChampionClass implements ChampionAttribute {

    ASSASSIN(R.drawable.class_assassin, "Assassin"),
    BLADEMASTER(R.drawable.class_blademaster, "Blademaster"),
    BRAWLER(R.drawable.class_brawler, "Brawler"),
    ELEMENTALIST(R.drawable.class_elementalist, "Elementalist"),
    GUARDIAN(R.drawable.class_guardian, "Guardian"),
    GUNSLINGER(R.drawable.class_gunslinger, "Gunslinger"),
    KNIGHT(R.drawable.class_knight, "Knight"),
    RANGER(R.drawable.class_ranger, "Ranger"),
    SHAPESHIFTER(R.drawable.class_shapeshifter, "Shapeshifter"),
    SORCERER(R.drawable.class_sorcerer, "Sorcerer");

    private int iconID;
    private String className;

    ChampionClass(int iconID, String className) {
        this.iconID = iconID;
        this.className = className;
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
}
