package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.Champions.ChampionClass;
import xyz.purposeless.tfthelper.Champions.ChampionGUIElements.ChampionAttributeFragment;
import xyz.purposeless.tfthelper.Champions.ChampionOrigin;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.Exception.TFTRuntimeException;
import xyz.purposeless.tfthelper.Utils.HexagonMaskView;

public class ChampionDetailActivity extends AppCompatActivity {
	private static final String TAG = "ChampionDetailActivity";


	private Champion chosenChampion;
	private ImageView champSplash;
	private HexagonMaskView champIcon;
	private LinearLayout champAttrs;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_champion_detail);

		AdView mAdView = findViewById(R.id.championDetailAdView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);


		this.champSplash = findViewById(R.id.detailChampionSplash);
		this.champIcon = findViewById(R.id.detailChampionIcon);
		this.champAttrs = findViewById(R.id.detailChampionAttributes);

		processChampion(getIntent().getStringExtra(ChampionHolderActivity.CHAMP_NAME_TAG));




	}

	private void processChampion(String champName) {
		this.chosenChampion = Champion.fromString(champName);
		if (this.chosenChampion == null) {
			throw new TFTRuntimeException(TAG + " error processing champion");
		}


		//Name
		if (getSupportActionBar() != null) {
			getSupportActionBar().setTitle(chosenChampion.getName());
		}

		//Images
//		this.champIcon.setImageResource(); //TODO Pull from net or include?
		this.champIcon.setImageResource(this.chosenChampion.getChampionImageID());

		//Attributes
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		ChampionAttributeFragment f;
		for (ChampionClass attr : this.chosenChampion.getClasses()) {
			f = ChampionAttributeFragment.newInstance(attr);
			f.setNumbersVisibility(false);
			transaction.add(this.champAttrs.getId(), f);
		}
		for (ChampionOrigin attr : this.chosenChampion.getOrigin()) {
			f = ChampionAttributeFragment.newInstance(attr);
			f.setNumbersVisibility(false);
			transaction.add(this.champAttrs.getId(), f);
		}
		transaction.commit();
	}
}
