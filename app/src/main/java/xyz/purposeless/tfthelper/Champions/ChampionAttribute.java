package xyz.purposeless.tfthelper.Champions;

import xyz.purposeless.tfthelper.Utils.Exception.TFTRuntimeException;

public interface ChampionAttribute {

    enum REQUIREMENT_STATUS {
        NOT_FULFILLED,
        FULFILLED,
        FULL
    }


    int getIconID();
    String getName();
    int[] getBonusReq();
//    String[] getBonusStrings();
    int getNextRequirement(int current);//return current if max has been reached

//    List<ChampionAttribute> getUsedValues();


    static REQUIREMENT_STATUS getRequirementStatus(int count, ChampionAttribute attr) {
        int[] effectRequired = attr.getBonusReq();

        if (count >= effectRequired[effectRequired.length-1]) {
            return REQUIREMENT_STATUS.FULL;
        } else if (count >= effectRequired[0]) {
            return REQUIREMENT_STATUS.FULFILLED;
        } else if (count >= 0){
            return REQUIREMENT_STATUS.NOT_FULFILLED;
        }

        throw new TFTRuntimeException("Unknown requirement status in ChampionAttribute");
    }

    static ChampionAttribute fromString(String attrName) {
        for (ChampionClass clazz : ChampionClass.values()) {
            if (clazz.getName().equals(attrName)) {
                return clazz;
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
