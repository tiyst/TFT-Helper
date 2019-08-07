package xyz.purposeless.tfthelper.Champions;

public interface ChampionAttribute {

    int getIconID();

    String getName();

    int[] getBonusReq();

    static ChampionAttribute fromString(String attrName) {
        for (ChampionClass clas : ChampionClass.values()) {
            if (clas.getName().equals(attrName)) {
                return clas;
            }
        }
        for (ChampionOrigin origin : ChampionOrigin.values()) {
            if (origin.getName().equals(attrName)) {
                return origin;
            }
        }

        return null;
    }
}
