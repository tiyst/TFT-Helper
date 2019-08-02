package xyz.purposeless.tfthelper.Champions;

import java.util.List;

public enum Champion {

    AATROX(),
    AHRI(),
    AKALI(),
    ANIVIA(),
    ASHE(),
    AURELIONSOL(),
    BLITZCRANK(),
    BRAND(),
    BRAUM(),
    CHOGATH(),
    DARIUS(),
    DRAVEN(),
    ELISE(),
    EVELYNN(),
    FIORA(),
    GANGPLANK(),
    GAREN(),
    GNAR(),
    GRAVES(),
    KARTHUS(),
    KASSADIN(),
    KATARINA(),
    KAYLE(),
    KENNEN(),
    KHAZIX(),
    KINDRED(),
    LEONA(),
    LISSANDRA(),
    LUCIAN(),
    LULU(),
    MISSFORTUNE(),
    MORDEKAISER(),
    MORGANA(),
    NIDALEE(),
    POPPY(),
    PYKE(),
    REKSAI(),
    RENGAR(),
    SEJUANI(),
    SHEN(),
    SHYVANA(),
    SWAIN(),
    TRISTANA(),
    TWISTEDFATE(),
    VARUS(),
    VAYNE(),
    VEIGAR(),
    VOLIBEAR(),
    WARWICK(),
    YASUO(),
    ZED();


    private int championImageID;

    private int moneyCost;
    private String name;
    private List<ChampionAttribute> attributes;

    Champion() {
        //mw implementation
    }

    Champion(int imgID, int cost, String name, List<ChampionAttribute> attributes) {
        this.championImageID = imgID;
        this.moneyCost = cost;
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return this.name;
    }

    public int getChampionImageID() {
        return championImageID;
    }

    public int getMoneyCost() {
        return moneyCost;
    }

    public List<ChampionAttribute> getAttributes() {
        return attributes;
    }

    public static Champion fromString(String name) {
        for (Champion champ : Champion.values()) {
            if (champ.getName().equals(name)) {
                return champ;
            }
        }
        return null;
    }
}
