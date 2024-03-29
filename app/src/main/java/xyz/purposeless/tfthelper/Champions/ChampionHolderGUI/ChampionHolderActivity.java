package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.Champions.ChampionClass;
import xyz.purposeless.tfthelper.Champions.ChampionGUIElements.ChampionFragment;
import xyz.purposeless.tfthelper.Champions.ChampionOrigin;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.Exception.TFTRuntimeException;

public class ChampionHolderActivity extends AppCompatActivity implements
        ChampionHolderCostFragment.onChampionHolderCostFragment,
        ChampionFragment.onChampFragmentInteractionListener {
    private static final String TAG = "ChampionHolderActivity";
    public static final String CHAMP_NAME_TAG = "ChampionName";

    private HolderController controller;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_holder);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        AdView mAdView = findViewById(R.id.championHolderAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        this.radioGroup = findViewById(R.id.groupingTypeRadioButtons);
        this.radioGroup.setOnCheckedChangeListener((group, checkedId) -> updateDivider(checkedId));
        this.controller = new HolderController(getClickedDivider(radioGroup.getCheckedRadioButtonId()));
    }

    private ChampionHolder.CHOSEN_DIVIDER getClickedDivider(int buttonID) {
        switch(buttonID) {
            case R.id.radioButtonClass:
                return ChampionHolder.CHOSEN_DIVIDER.CLASS;
            case R.id.radioButtonCost:
                return  ChampionHolder.CHOSEN_DIVIDER.COST;
            case R.id.radioButtonOrigin:
                return ChampionHolder.CHOSEN_DIVIDER.ORIGIN;

            default:
                throw new TFTRuntimeException("Clicked radio doesn't exist (apparently).\n" +
                        " Also WTF?!");
        }
    }

    private void updateDivider(int clickedID) {
        updateDivider(getClickedDivider(clickedID));
    }

    private void updateDivider(ChampionHolder.CHOSEN_DIVIDER clicked) {
        controller.setDividerType(clicked);
    }

    @Override
    public void onChampionHolderCostFragmentInteraction() {

    }

    @Override
    public void onChampionInteraction(Champion champion) {
        Intent intent = new Intent(this, ChampionDetailActivity.class);
        intent.putExtra(CHAMP_NAME_TAG, champion.getName());
        startActivity(intent);
    }

    
    private class HolderController {

        private List<ChampionHolder> holders;
        private ChampionHolder.CHOSEN_DIVIDER currentDivider;

        HolderController(ChampionHolder.CHOSEN_DIVIDER divider) {
            this.holders = new ArrayList<>();
            this.currentDivider = divider;
            changeDividerFragments(divider);
        }

        void setDividerType(ChampionHolder.CHOSEN_DIVIDER divider) {
            if (divider != null && divider != this.currentDivider) {
                this.currentDivider = divider;
                changeDividerFragments(divider);
            }
        }

        private void changeDividerFragments(ChampionHolder.CHOSEN_DIVIDER divider) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

            for (ChampionHolder holder : this.holders) {
                transaction.remove(holder);
            }
            holders.clear();

            ChampionHolder[] toBeAddedFragments = getChampionHolders(divider);
            for (ChampionHolder newHolder : toBeAddedFragments) {
                holders.add(newHolder);
                transaction.add(R.id.championDividerLayout, newHolder);
            }
            transaction.commitNow();

            for (ChampionHolder hold : this.holders) {
                hold.fillWithChampions();
            }
        }

        private ChampionHolder[] getChampionHolders(ChampionHolder.CHOSEN_DIVIDER divider) {
            if (divider == ChampionHolder.CHOSEN_DIVIDER.COST) {
                ChampionHolder[] holder = new ChampionHolder[5];
                for (int i = 0; i < 5; i++) {
                    holder[i] = ChampionHolderCostFragment.newInstance(i + 1);
                }
                return holder;
            } else {
                List<ChampionHolder> holders = new ArrayList<>();
                int size;
                if (divider == ChampionHolder.CHOSEN_DIVIDER.ORIGIN) {
                    for (ChampionOrigin origin : ChampionOrigin.values()) {
                        holders.add(ChampionHolderAttributeFragment.newInstance(origin));
                    }
                    size = ChampionOrigin.values().length;
                } else {
                    for (ChampionClass clazz : ChampionClass.values()) {
                        holders.add(ChampionHolderAttributeFragment.newInstance(clazz));
                    }
                    size = ChampionClass.values().length;
                }
                return holders.toArray(new ChampionHolder[size]);
            }
        }


    }
}
