package xyz.purposeless.tfthelper.Champions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyz.purposeless.tfthelper.Utils.Exception.TFTRuntimeException;
import xyz.purposeless.tfthelper.R;

public enum Champion {

    AATROX(R.drawable.champion_aatrox,3,"Aatrox",ChampionOrigin.DEMON,ChampionClass.BLADEMASTER),
    AHRI(R.drawable.champion_ahri,2,"Ahri", ChampionOrigin.WILD, ChampionClass.SORCERER),
    AKALI(R.drawable.champion_akali,4,"Akali", ChampionOrigin.NINJA, ChampionClass.ASSASSIN),
    ANIVIA(R.drawable.champion_anivia,5, "Anivia", ChampionOrigin.GLACIAL, ChampionClass.ELEMENTALIST),
    ASHE(R.drawable.champion_ashe, 3, "Ashe", ChampionOrigin.GLACIAL, ChampionClass.RANGER),
    AURELIONSOL(R.drawable.champion_aurelionsol, 4, "Aurelion Sol",ChampionOrigin.DRAGON, ChampionClass.SORCERER),
    BLITZCRANK(R.drawable.champion_blitzcrank, 2, "Blitzcrank", ChampionOrigin.ROBOT, ChampionClass.BRAWLER),
    BRAND(R.drawable.champion_brand, 4, "Brand", ChampionOrigin.DEMON, ChampionClass.ELEMENTALIST),
    BRAUM(R.drawable.champion_braum, 2, "Braum", ChampionOrigin.GLACIAL, ChampionClass.GUARDIAN),
    CAMILLE(R.drawable.champion_camille, 1, "Camille", ChampionOrigin.HEXTECH, ChampionClass.BLADEMASTER),
    CHOGATH(R.drawable.champion_chogath, 4, "Cho'Gath", ChampionOrigin.VOID, ChampionClass.BRAWLER),
    DARIUS(R.drawable.champion_darius, 1, "Darius", ChampionOrigin.IMPERIAL, ChampionClass.KNIGHT),
    DRAVEN(R.drawable.champion_draven, 4, "Draven", ChampionOrigin.IMPERIAL, ChampionClass.BLADEMASTER),
    ELISE(R.drawable.champion_elise, 1, "Elise", ChampionOrigin.DEMON, ChampionClass.SHAPESHIFTER),
    EVELYNN(R.drawable.champion_evelynn, 3, "Evelynn",ChampionOrigin.DEMON, ChampionClass.ASSASSIN),
    FIORA(R.drawable.champion_fiora, 1, "Fiora", ChampionOrigin.NOBLE, ChampionClass.BLADEMASTER),
    GANGPLANK(R.drawable.champion_gangplank, 3, "Gangplank", ChampionOrigin.PIRATE, ChampionClass.BLADEMASTER, ChampionClass.GUNSLINGER),
    GAREN(R.drawable.champion_garen, 1, "Garen", ChampionOrigin.NOBLE, ChampionClass.KNIGHT),
    GNAR(R.drawable.champion_gnar, 4, "Gnar", new ChampionOrigin[] {ChampionOrigin.YORDLE, ChampionOrigin.WILD}, ChampionClass.SHAPESHIFTER),
    GRAVES(R.drawable.champion_graves, 1, "Graves", ChampionOrigin.PIRATE, ChampionClass.GUNSLINGER),
    JAYCE(R.drawable.champion_jayce, 2, "Jayce", ChampionOrigin.HEXTECH, ChampionClass.SHAPESHIFTER),
    JINX(R.drawable.champion_jinx, 4, "Jinx", ChampionOrigin.HEXTECH, ChampionClass.GUNSLINGER),
    KARTHUS(R.drawable.champion_karthus, 5, "Karthus", ChampionOrigin.PHANTOM, ChampionClass.SORCERER),
    KASSADIN(R.drawable.champion_kassadin, 1, "Kassadin", ChampionOrigin.VOID, ChampionClass.SORCERER),
    KATARINA(R.drawable.champion_katarina, 3, "Katarina", ChampionOrigin.IMPERIAL, ChampionClass.ASSASSIN),
    KAYLE(R.drawable.champion_kayle, 5, "Kayle", ChampionOrigin.NOBLE, ChampionClass.KNIGHT),
    KENNEN(R.drawable.champion_kennen, 3, "Kennen", new ChampionOrigin[] {ChampionOrigin.YORDLE, ChampionOrigin.NINJA}, ChampionClass.ELEMENTALIST ),
    KHAZIX(R.drawable.champion_khazix, 1, "Kha'Zix", ChampionOrigin.VOID, ChampionClass.ASSASSIN),
    KINDRED(R.drawable.champion_kindred, 4, "Kindred", ChampionOrigin.PHANTOM, ChampionClass.RANGER),
    LEONA(R.drawable.champion_leona, 4, "Leona", ChampionOrigin.NOBLE, ChampionClass.GUARDIAN),
    LISSANDRA(R.drawable.champion_lissandra, 2, "Lissandra", ChampionOrigin.GLACIAL, ChampionClass.ELEMENTALIST),
    LUCIAN(R.drawable.champion_lucian, 2, "Lucian", ChampionOrigin.NOBLE, ChampionClass.GUNSLINGER),
    LULU(R.drawable.champion_lulu, 2, "Lulu", ChampionOrigin.YORDLE, ChampionClass.SORCERER),
    MISSFORTUNE(R.drawable.champion_missfortune, 5, "Miss Fortune", ChampionOrigin.PIRATE, ChampionClass.GUNSLINGER),
    MORDEKAISER(R.drawable.champion_mordekaiser, 1, "Mordekaiser", ChampionOrigin.PHANTOM, ChampionClass.KNIGHT),
    MORGANA(R.drawable.champion_morgana, 3, "Morgana", ChampionOrigin.DEMON, ChampionClass.SORCERER),
    NIDALEE(R.drawable.champion_nidalee, 1, "Nidalee", ChampionOrigin.WILD, ChampionClass.SHAPESHIFTER),
    POPPY(R.drawable.champion_poppy, 3, "Poppy", ChampionOrigin.YORDLE, ChampionClass.KNIGHT),
    PYKE(R.drawable.champion_pyke, 2, "Pyke", ChampionOrigin.PIRATE, ChampionClass.ASSASSIN),
    REKSAI(R.drawable.champion_reksai, 2, "Rek'Sai", ChampionOrigin.VOID, ChampionClass.BRAWLER),
    RENGAR(R.drawable.champion_rengar, 3, "Rengar", ChampionOrigin.WILD, ChampionClass.ASSASSIN),
    SEJUANI(R.drawable.champion_sejuani, 4, "Sejuani", ChampionOrigin.GLACIAL, ChampionClass.KNIGHT),
    SHEN(R.drawable.champion_shen, 2, "Shen", ChampionOrigin.NINJA, ChampionClass.BLADEMASTER),
    SHYVANA(R.drawable.champion_shyvana, 3, "Shyvana", ChampionOrigin.DRAGON, ChampionClass.SHAPESHIFTER),
    SWAIN(R.drawable.champion_swain, 5, "Swain", new ChampionOrigin[] {ChampionOrigin.IMPERIAL, ChampionOrigin.DEMON}, ChampionClass.SHAPESHIFTER),
    TRISTANA(R.drawable.champion_tristana, 1, "Tristana", ChampionOrigin.YORDLE, ChampionClass.GUNSLINGER),
    TWISTEDFATE(R.drawable.champion_twistedfate, 2, "Twisted Fate", ChampionOrigin.PIRATE, ChampionClass.SORCERER),
    VARUS(R.drawable.champion_varus, 2, "Varus", ChampionOrigin.DEMON, ChampionClass.RANGER),
    VAYNE(R.drawable.champion_vayne, 1, "Vayne", ChampionOrigin.NOBLE, ChampionClass.RANGER),
    VEIGAR(R.drawable.champion_veigar, 3, "Veigar", ChampionOrigin.YORDLE, ChampionClass.SORCERER),
    VI(R.drawable.champion_vi, 3, "Vi", ChampionOrigin.HEXTECH, ChampionClass.BRAWLER),
    VOLIBEAR(R.drawable.champion_volibear, 3, "Volibear", ChampionOrigin.GLACIAL, ChampionClass.BRAWLER),
    WARWICK(R.drawable.champion_warwick, 1, "Warwick", ChampionOrigin.WILD, ChampionClass.BRAWLER),
    YASUO(R.drawable.champion_yasuo, 5, "Yasuo", ChampionOrigin.EXILE, ChampionClass.BLADEMASTER),
    ZED(R.drawable.champion_zed, 2, "Zed", ChampionOrigin.NINJA, ChampionClass.ASSASSIN),
    PLACEHOLDER(R.drawable.question_mark,-1, "Placeholder", ChampionOrigin.NINJA, ChampionClass.ASSASSIN);


    private int championImageID;

    private int cost;
    private String name;
    private List<ChampionOrigin> origins;
    private List<ChampionClass> classes;

    Champion(int imgID, int cost, String name, ChampionAttribute... attributes) {
        //TODO move to this constructor, will make creating / editing champions much easier

        this.championImageID = imgID;
        this.cost = cost;
        this.name = name;
        this.origins = new ArrayList<>();
        this.classes = new ArrayList<>();
        for (ChampionAttribute attr : attributes) {
            if (attr instanceof ChampionOrigin) {
                origins.add((ChampionOrigin) attr);
            } else if (attr instanceof ChampionClass) {
                classes.add((ChampionClass) attr);
            } else {
                throw new TFTRuntimeException("Error parsing champion attributes. " +
                        "\nPlease report this to the developer at tiystw@gmail.com");
            }
        }
    }

    Champion(int imgID, int cost, String name, ChampionOrigin origins, ChampionClass... classes) {
        this.championImageID = imgID;
        this.cost = cost;
        this.name = name;
        this.origins = new ArrayList<>();
        this.origins.add(origins);
        this.classes = new ArrayList<>();
        this.classes.addAll(Arrays.asList(classes));
    }

    Champion(int imgID, int cost, String name, ChampionOrigin[] origins, ChampionClass... classes) {
        this.championImageID = imgID;
        this.cost = cost;
        this.name = name;
        this.origins = new ArrayList<>();
        this.origins.addAll(Arrays.asList(origins));
        this.classes = new ArrayList<>();
        this.classes.addAll(Arrays.asList(classes));
    }

    public String getName() {
        return this.name;
    }

    public int getChampionImageID() {
        return championImageID;
    }

    public int getCost() {
        return cost;
    }

    public List<ChampionOrigin> getOrigin() {
        return origins;
    }

    public List<ChampionClass> getClasses() {
        return classes;
    }

    public boolean hasAttribute(ChampionAttribute attr) {
        return (this.getOrigin().contains(attr) || this.getClasses().contains(attr));
    }

    public static Champion fromString(String name) {
        for (Champion champ : Champion.values()) {
            if (champ.getName().equals(name)) {
                return champ;
            }
        }
        return null;
    }

    public static List<Champion> getByOrigin(ChampionOrigin origin) {
        ArrayList<Champion> champions = new ArrayList<>();
        for (Champion champ : Champion.values()) {
            if (champ.getOrigin().contains(origin)) {
                champions.add(champ);
            }
        }
        return champions;
    }

    public static List<Champion> getByClass(ChampionClass clas) {
        ArrayList<Champion> champions = new ArrayList<>();
        for (Champion champ : Champion.values()) {
            if (champ.getClasses().contains(clas)) {
                champions.add(champ);
            }
        }
        return champions;
    }

    public static List<Champion> getByCost(int cost) {
        ArrayList<Champion> champions = new ArrayList<>();
        for (Champion champ : Champion.values()) {
            if (champ.getCost() == cost) {
                champions.add(champ);
            }
        }
        return champions;
    }

    public static Champion[] getUsedChampions() {
        //If you do not init with copy constructor it will be of fixed size and remove will crash the app
        List<Champion> champions = new ArrayList<>(Arrays.asList(Champion.values()));
        champions.remove(Champion.PLACEHOLDER);


        //TODO this can be updated as patches go on.
        return champions.toArray(new Champion[Champion.values().length-1]);
    }

    public static ArrayList<Champion> getChampionsByAttribute(ChampionAttribute attr) {
        ArrayList<Champion> champs = new ArrayList<>();

        for (Champion champ : getUsedChampions()) {
            if (champ.hasAttribute(attr)) {
                champs.add(champ);
            }
        }
        return champs;
    }
}
