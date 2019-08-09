package xyz.purposeless.tfthelper.Champions;

public interface ChampionAttribute {

    enum REQUIREMENT_STATUS {
        NOT_FULFILLED,
        FULFILLED,
        FULL;
    }

    int getIconID();

    String getName();

    int[] getBonusReq();

    //return current if max has been reached
    int getNextRequirement(int current);

    REQUIREMENT_STATUS meetsRequirements(int count);

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
