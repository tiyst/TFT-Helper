package xyz.purposeless.tfthelper;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import xyz.purposeless.tfthelper.Items.ItemFragment;
import xyz.purposeless.tfthelper.Items.TFTItemEnum;

public class ItemsActivity extends AppCompatActivity implements ItemFragment.TFTItemListener {

    private static final String TAG = "ItemsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        fillWithItems();
    }



    public void fillWithItems() {
//        androidx.gridlayout.widget.GridLayout  grid = findViewById(R.id.gridItemsChoosingLayout);
        LinearLayout grid = findViewById(R.id.itemsChoosingLayout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < TFTItemEnum.values().length; i++) {
            fragmentTransaction.add(grid.getId(), ItemFragment.newInstance("ay?"), "fragment" + i);
            //fragmentTransaction.add(ItemFragment.newInstance("ay?"),"");
            Log.d(TAG, "fillWithItems: " + (i+1));
        }
        fragmentTransaction.commit();


        /*mLocationsGrid = (GridLayout) gridParent.findViewById(R.id.grid);
        int columns = grid.getColumnCount();
        Adapter = new MyAdapter(mContext, this, mResolver); //This is how I keep track of the various fragments depending on my app's state
        int nCards = mAdapter.getNumberOfCards();
        FragmentManager fragmentManager = mParentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < nCards; ++i) {
            fragmentTransaction.add(mLocationsGrid.getId(), mAdapter.getFragmentAtIndex(i), String.valueOf(i));
        }
        fragmentTransaction.commit();
        mPopulated = true;*/
    }

    @Override
    public void onItemInteraction(TFTItemEnum item) {
        Log.d(TAG, "Item name: " + item.getItemName() +
                "\nItem desc: " + item.getItemDescription());
    }
}
