package xyz.purposeless.tfthelper.Champions.ChampionBuilderGUI;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.gridlayout.widget.GridLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.Champions.ChampionAttribute;
import xyz.purposeless.tfthelper.Champions.ChampionClass;
import xyz.purposeless.tfthelper.Champions.ChampionGUIElements.ChampionAttributeFragment;
import xyz.purposeless.tfthelper.Champions.ChampionGUIElements.ChampionFragment;
import xyz.purposeless.tfthelper.Champions.ChampionOrigin;
import xyz.purposeless.tfthelper.Exception.TFTRuntimeException;
import xyz.purposeless.tfthelper.R;

public class ChampionBuilderActivity extends AppCompatActivity implements
        ChampionFragment.onChampFragmentInteractionListener,
        ChampionTeamFragment.ownedChampionInteractionListener {

    ChampionController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);
        controller = new ChampionController();
        initChampions();
    }

    private void initChampions() {
        GridLayout layout = findViewById(R.id.gridChampLayout);
        LinearLayout linearLayout = findViewById(R.id.ownedChampionsLayout);

        //All champions
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < Champion.values().length; i++) {
            fragmentTransaction.add(layout.getId(),
                    ChampionFragment.newInstance(Champion.values()[i].getName()));
        }
        fragmentTransaction.commitNow();

        //Owned champions
        fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < 10; i++) {
            ChampionTeamFragment f = ChampionTeamFragment.newInstance(Champion.PLACEHOLDER.getName());
            fragmentTransaction.add(linearLayout.getId(), f, String.valueOf(i));
        }
        fragmentTransaction.commitNow();
    }


    @Override
    public void onChampionInteraction(Champion champion) {
        controller.addChampion(champion);
    }

    @Override
    public void ownedChampionInteraction(Champion champion) {
        controller.removeChampion(champion);
    }


    private class ChampionController {

        private Map<ChampionAttribute, Integer> attributes;
        private List<Champion> champions;

        ChampionController() {
            this.attributes = new HashMap<>();
            for (ChampionOrigin origin :ChampionOrigin.values()) {
                attributes.put(origin,0);
            }
            for (ChampionClass clas : ChampionClass.values()) {
                attributes.put(clas,0);
            }
            this.champions = new ArrayList<>();
        }

        void addChampion(Champion champ) {
            if (!this.champions.contains(champ)) {
                this.champions.add(champ);
                for (ChampionOrigin origin : champ.getOrigin()) {
                    addAttribute(origin);
                }
                for (ChampionClass clas: champ.getClasses()) {
                    addAttribute(clas);
                }
            } else {
                Toast.makeText(ChampionBuilderActivity.this, champ.getName() + getString(R.string.championAlreadyPresent), Toast.LENGTH_SHORT).show();
            }
        }

        void removeChampion(Champion champ) {
            if (this.champions.contains(champ)) {
                this.champions.remove(champ);
                for (ChampionOrigin origin : champ.getOrigin()) {
                    removeAttribute(origin);
                }
                for (ChampionClass clas: champ.getClasses()) {
                    removeAttribute(clas);
                }
            } else {
                throw new TFTRuntimeException("You done goofed. Now go and fix it.");
            }
        }

        void addAttribute(ChampionAttribute attr) {
            this.attributes.put(attr, this.attributes.get(attr) + 1);
            checkAttributes(attr);
        }


        void removeAttribute(ChampionAttribute attr) {
            this.attributes.put(attr, this.attributes.get(attr) - 1);
            checkAttributes(attr);
        }

        void checkAttributes(ChampionAttribute attr) {
            Integer count = this.attributes.get(attr);
            if (count == 0) { //No more of this attr
                removeAttributeFragment(attr);
            }
            if (count == 1) { //Freshly added
                addAttributeFragment(attr);
            }

            //Controlling if max req. has been met
            if (count == attr.getBonusReq()[attr.getBonusReq().length-1]) {
                fullAttributeFragment(attr);
            } else {
                notFullAttributeFragment(attr);
            }
        }


        void checkAttributes() {
            for (Map.Entry<ChampionAttribute,Integer> entry : this.attributes.entrySet()) {
                if (entry.getValue() == 0) { //This attribute
                    removeAttributeFragment(entry.getKey());
                }

                int[] bonusRequirements = entry.getKey().getBonusReq();
                if (entry.getValue() == bonusRequirements[bonusRequirements.length-1]) {
                    fullAttributeFragment(entry.getKey());
                } else {
                    notFullAttributeFragment(entry.getKey());
                }
            }
        }

        //Adds attribute fragment (at least 1 champ with attribute is in pool)
        void addAttributeFragment(ChampionAttribute attr) {
            ChampionFragment f = (ChampionFragment) getSupportFragmentManager().findFragmentByTag(attr.getName());
            if (f != null) {
                FragmentTransaction fManager = getSupportFragmentManager().beginTransaction();
                fManager.add(R.id.ownedAttributesLayout,
                        ChampionAttributeFragment.newInstance(attr.getName()), attr.getName());
                fManager.commitNow();
            }
        }

        //Completely removes attribute fragment (0 champions in chAttribute)
        void removeAttributeFragment(ChampionAttribute attr) {
            ChampionFragment f = (ChampionFragment) getSupportFragmentManager().findFragmentByTag(attr.getName());
            if(f != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(f);
                transaction.commitNow();
            }
        }

        void checkGoldenRequirements() {

        }

        //when attribute minimum isn't met, draw icon grey
        void notFullAttributeFragment(ChampionAttribute attr) {

        }

        //when attribute minimum is met, draw icon gold
        void fullAttributeFragment(ChampionAttribute attr) {

        }
    }
}
