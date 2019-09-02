package xyz.purposeless.tfthelper;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import xyz.purposeless.tfthelper.Champions.ChampionBuilderGUI.ChampionBuilderActivity;
import xyz.purposeless.tfthelper.Champions.ChampionHolderGUI.ChampionHolderActivity;
import xyz.purposeless.tfthelper.Items.ItemInventoryGUI.ItemActivity;
import xyz.purposeless.tfthelper.Items.ItemQuizGUI.ItemQuizActivity;

public class MainActivity extends AppCompatActivity {

    private static Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}

		ConstraintLayout constraintLayout = findViewById(R.id.mainParentLayout);
		AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
		animationDrawable.setEnterFadeDuration(5000);
		animationDrawable.setExitFadeDuration(2000);
		animationDrawable.start();


		mContext = this;
	}

	public void itemsOnClick(View view) {
		startActivity(new Intent(this, ItemActivity.class));
	}

	public void itemsQuizOnClick(View view) {
		startActivity(new Intent(this, ItemQuizActivity.class));
	}

	public void championBuilderOnClick(View view) {
		startActivity(new Intent(this, ChampionBuilderActivity.class));
	}

	public void championDividerOnClick(View view) {
		startActivity(new Intent(this, ChampionHolderActivity.class));
	}

	public void fabAboutClicked(View v) {

	}

    public static Context getContext() {
        return mContext;
    }
}
