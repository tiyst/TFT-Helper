package xyz.purposeless.tfthelper.Champions.ChampionHolderGUI;

import androidx.fragment.app.Fragment;

import xyz.purposeless.tfthelper.Champions.ChampionClass;
import xyz.purposeless.tfthelper.Champions.ChampionOrigin;

public abstract class ChampionHolder extends Fragment {

	public enum CHOSEN_DIVIDER {
		CLASS(ChampionClass.values().length),
		ORIGIN(ChampionOrigin.values().length),
		COST(5); //5 tiers of champions

		public final int count;
		CHOSEN_DIVIDER(int count) {
			this.count = count;
		}
	}

	public abstract void fillWithChampions();

}
