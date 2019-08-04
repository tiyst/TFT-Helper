package xyz.purposeless.tfthelper.Champions.ChampionGUI;

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
import xyz.purposeless.tfthelper.Champions.ChampionOrigin;
import xyz.purposeless.tfthelper.Exception.TFTRuntimeException;
import xyz.purposeless.tfthelper.R;

public class ChampionActivity extends AppCompatActivity implements
        ChampionFragment.onChampFragmentInteractionListener {

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
            ChampionFragment f = new ChampionFragment();
            f.questionMark();
            fragmentTransaction.add(linearLayout.getId(), f, String.valueOf(i));
        }
    }


    @Override
    public void onChampionInteraction(Champion champion) {
        controller.addChampion(champion);
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
                Toast.makeText(ChampionActivity.this, champ.getName() + getString(R.string.championAlreadyPresent), Toast.LENGTH_SHORT).show();
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
            addAttributeFragment(attr);
            this.attributes.put(attr, this.attributes.get(attr) + 1);
//            checkAttributes();
        }


        void removeAttribute(ChampionAttribute attr) {
            this.attributes.put(attr, this.attributes.get(attr) - 1);
//            checkAttributes();
            removeAttributeFragment(attr);
        }


        void checkAttributes() {

        }

        //Adds attribute fragment (at least 1 champ with attribute is in pool)
        void addAttributeFragment(ChampionAttribute attr) {
            if (attributes.get(attr) == 0) {
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

        //when attribute minimum isn't met, make icon transparent
        void notFullAttributeFragment(ChampionAttribute attr) {

        }

        //when attribute minimum is met, make icon not transparent
        void fullAttributeFragment(ChampionAttribute attr, boolean maxChampions) {

        }
    }
}
