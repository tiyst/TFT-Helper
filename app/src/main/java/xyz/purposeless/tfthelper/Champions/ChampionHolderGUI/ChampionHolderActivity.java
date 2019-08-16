package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.Exception.TFTRuntimeException;

public class ChampionHolderActivity extends AppCompatActivity {
    private static final String TAG = "ChampionHolderActivity";

    public enum CHOSEN_DIVIDER {
        CLASS,
        ORIGIN,
        COST
    }

    private HolderController controller;
    private CHOSEN_DIVIDER divider;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_holder);

        controller = new HolderController();
        this.radioGroup = findViewById(R.id.groupingTypeRadioButtons);
        this.radioGroup.setOnCheckedChangeListener((group, checkedId) -> updateDivider(checkedId));
        updateDivider(this.radioGroup.getCheckedRadioButtonId());
    }

    private CHOSEN_DIVIDER getClickedDivider(int buttonID) {
        switch(buttonID) {
            case R.id.radioButtonClass:
                return CHOSEN_DIVIDER.CLASS;
            case R.id.radioButtonCost:
                return  CHOSEN_DIVIDER.COST;
            case R.id.radioButtonOrigin:
                return CHOSEN_DIVIDER.ORIGIN;

            default:
                //FIXME onradiobuttonclicked reacts to whole view, not just buttons
                Log.d(TAG, "wrong button ID ->" + buttonID);
                throw new TFTRuntimeException("Clicked radio doesn't exist (apparently)." +
                        " Also WTF?!");
        }
    }

    private void updateDivider(int clickedID) {
        updateDivider(getClickedDivider(clickedID));
    }

    private void updateDivider(CHOSEN_DIVIDER clicked) {
        controller.setDividerType(clicked);
        Log.d(TAG, "updateDivider: "+ clicked);
    }



    private class HolderController {

        private List<ChampionHolder> holders;
        private CHOSEN_DIVIDER currentDivider;

        HolderController() {
            holders = new ArrayList<>();
        }

        void setDividerType(CHOSEN_DIVIDER divider) {
            if (divider != null && divider != this.currentDivider) {
                this.currentDivider = divider;
                resetHolders();
                addDividerFragments(divider);
            }
        }

        void resetHolders() {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            for (ChampionHolder holder: this.holders) {
                transaction.remove(holder);
            }
            transaction.commitNow();
        }

        public void addHolderFragment(ChampionHolder holderType) {
            holders.add(holderType);
        }

        private void addDividerFragments(CHOSEN_DIVIDER divider) {
            
        }
    }
}
