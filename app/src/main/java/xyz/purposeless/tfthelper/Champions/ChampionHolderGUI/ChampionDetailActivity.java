package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import xyz.purposeless.tfthelper.Champions.Champion;
import xyz.purposeless.tfthelper.R;

public class ChampionDetailActivity extends AppCompatActivity {

	private Champion chosenChampion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_champion_detail);
	}
}
