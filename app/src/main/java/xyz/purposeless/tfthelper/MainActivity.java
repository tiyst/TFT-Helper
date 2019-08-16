package xyz.purposeless.tfthelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import xyz.purposeless.tfthelper.Champions.ChampionBuilderGUI.ChampionBuilderActivity;
import xyz.purposeless.tfthelper.Champions.ChampionHolderGUI.ChampionHolderActivity;
import xyz.purposeless.tfthelper.Items.ItemGUI.ItemActivity;

public class MainActivity extends AppCompatActivity {

    private static Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}
		mContext = this;
	}

	public void itemsOnClick(View view) {
		startActivity(new Intent(this, ItemActivity.class));
	}

	public void championBuilderOnClick(View view) {
		startActivity(new Intent(this, ChampionBuilderActivity.class));
	}

	public void championDividerOnClick(View view) {
		startActivity(new Intent(this, ChampionHolderActivity.class));
	}



    public static Context getContext() {
        return mContext;
    }
}
