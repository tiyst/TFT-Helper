package xyz.purposeless.tfthelper;

import org.junit.Assert;
import org.junit.Test;

import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.Items.TFTItemEnum;

import static org.junit.Assert.assertEquals;

public class BaseItemTests {


	@Test
	public void getBaseItemsTest() {
		assertEquals(TFTItemBaseEnum.fromString(), TFTItemBaseEnum.BFSword);
	}
}