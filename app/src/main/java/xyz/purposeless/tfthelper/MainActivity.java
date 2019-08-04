package xyz.purposeless.tfthelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import xyz.purposeless.tfthelper.Champions.ChampionGUI.ChampionActivity;
import xyz.purposeless.tfthelper.Items.ItemGUI.ItemActivity;

public class MainActivity extends AppCompatActivity {

    private static Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
	}

	public void itemsOnClick(View view) {
		startActivity(new Intent(this, ItemActivity.class));
	}

	public void champsOnClick(View view) {
		startActivity(new Intent(this, ChampionActivity.class));
	}

    public static Context getContext() {
        return mContext;
    }
}
