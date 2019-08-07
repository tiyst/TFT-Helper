package xyz.purposeless.tfthelper.Champions.ChampionBuilderGUI;

import android.os.Bundle;
import android.util.Log;
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
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initChampions();
    }

    private void initChampions() {
        GridLayout allChampionsLayout = findViewById(R.id.gridChampLayout);
        LinearLayout ownedChampionsLayout = findViewById(R.id.ownedChampionsLayout);

        //All champions
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < Champion.values().length; i++) {
            fragmentTransaction.add(allChampionsLayout.getId(),
                    ChampionFragment.newInstance(Champion.values()[i].getName()));
        }
        fragmentTransaction.commitNow();
    }


    @Override
    public void onChampionInteraction(Champion champion) {
        Log.d("Yee", "onChampionInteraction: adding champion " + champion.getName());
        controller.addChampion(champion);
    }

    @Override
    public void ownedChampionInteraction(Champion champion) {
        Log.d("Yee", "onChampionInteraction: removing champion " + champion.getName());
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
            for (ChampionClass clazz : ChampionClass.values()) {
                attributes.put(clazz,0);
            }
            this.champions = new ArrayList<>();
        }

        void addChampion(Champion champ) {
            if (!this.champions.contains(champ)) {
                addChampionTeamFragment(champ);
                this.champions.add(champ);
                for (ChampionOrigin origin : champ.getOrigin()) {
                    addAttribute(origin);
                }
                for (ChampionClass clazz: champ.getClasses()) {
                    addAttribute(clazz);
                }
            } else {
                Toast.makeText(ChampionBuilderActivity.this, champ.getName() + getString(R.string.championAlreadyPresent), Toast.LENGTH_SHORT).show();
            }
        }

        void removeChampion(Champion champ) {
            if (this.champions.contains(champ)) {
                for (ChampionOrigin origin : champ.getOrigin()) {
                    removeAttribute(origin);
                }
                for (ChampionClass clazz: champ.getClasses()) {
                    removeAttribute(clazz);
                }
                this.champions.remove(champ);
                removeChampionTeamFragment(champ);
            } else {
                throw new TFTRuntimeException("You done goofed. Now go and fix it.");
            }
        }
        
        void addChampionTeamFragment(Champion champion) {
//            ChampionTeamFragment f = (ChampionTeamFragment) getSupportFragmentManager().findFragmentByTag(String.valueOf(champion));
            FragmentTransaction fManager = getSupportFragmentManager().beginTransaction();
            fManager.add(R.id.ownedChampionsLayout,
                    ChampionTeamFragment.newInstance(champion.getName()),champion.getName());
            fManager.commitNow();

        }

        void removeChampionTeamFragment(Champion champion) {
            ChampionTeamFragment f = (ChampionTeamFragment) getSupportFragmentManager().findFragmentByTag(champion.getName());
            if(f != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(f);
                transaction.commitNow();
//                addChampionTeamFragment(Champion.PLACEHOLDER);
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
            if (count == attr.getBonusReq()[attr.getBonusReq().length - 1]) {
                fullAttributeFragment(attr);
            } else {
                notFullAttributeFragment(attr);
            }
        }


        //Adds attribute fragment (at least 1 champ with attribute is in pool)
        void addAttributeFragment(ChampionAttribute attr) {
            ChampionAttributeFragment f = (ChampionAttributeFragment) getSupportFragmentManager().findFragmentByTag(attr.getName());
            if (f == null) {
                FragmentTransaction fManager = getSupportFragmentManager().beginTransaction();
                fManager.add(R.id.ownedAttributesLayout,
                        ChampionAttributeFragment.newInstance(attr.getName()), attr.getName());
                fManager.commitNow();
            }
        }

        //Completely removes attribute fragment (0 champions in chAttribute)
        void removeAttributeFragment(ChampionAttribute attr) {
            ChampionAttributeFragment f = (ChampionAttributeFragment) getSupportFragmentManager().findFragmentByTag(attr.getName());
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
