package xyz.purposeless.tfthelper.Champions;

public interface ChampionAttribute {

    int getIconID();

    String getName();
    //TODO redo to abstract class, so I can 'fromString' from here rather from enums  !!!

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
