package xyz.purposeless.tfthelper.Items;

import android.media.Image;

import java.net.URL;
import java.util.List;

public class TFTItemClassVersion {
	//TODO Maybe redo this to enum??

	private Image mImage;
	private String mItemName;
	private TFTItemClassVersion[] mParentItems;
	private boolean isCombined;

	public TFTItemClassVersion(String imgResourceName, String itemName, List<TFTItemClassVersion> parentItems) {
		URL imgURL = TFTItemClassVersion.class.getResource(imgResourceName); //TODO How does this work in Android?

		this.mItemName = itemName;

		if (parentItems.size() != 2) {
			isCombined = false;
		} else {
			isCombined = true;
			mParentItems[0] = parentItems.get(0);
			mParentItems[1] = parentItems.get(1);
		}
	}
}
