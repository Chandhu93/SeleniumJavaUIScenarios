package com.flipkart.cart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.flipkart.genericUtility.BaseClass;
import com.flipkart.objectRepo.CartPage;
import com.flipkart.objectRepo.FlipkartHomePage;
import com.flipkart.objectRepo.MenTShirtPage;
import com.flipkart.objectRepo.ProductPage;
import com.flipkart.objectRepo.SelectedTshirtPage;

public class FlipkartCartTest  extends BaseClass{
	@Test
	public void menTShirt() throws InterruptedException, IOException {
		
		FlipkartHomePage hp = new FlipkartHomePage(driver);
		hp.searchProduct(eLib.readDataFromExcel("sheet1", 0, 0));
		
		ProductPage pp = new ProductPage(driver);
		pp.clickTShirtSection(driver, wLib);;
		
		MenTShirtPage mtp = new MenTShirtPage(driver);
		mtp.selectTshirt(driver, wLib);
		
		wLib.switchToTab(driver);
		
		SelectedTshirtPage stp = new SelectedTshirtPage(driver);
		stp.addTshirtToCart(driver, wLib);;
		
		wLib.getParentWid(driver);
		mtp.clickCartBtn();
		
		CartPage cp = new CartPage(driver);
		cp.clickPluseBtn(driver, wLib);
		
		int pr =cp.priceInInt(driver, wLib, jLib);
		int tpr =cp.totalpriceInInt(driver, wLib, jLib);
		System.out.println(pr+":"+ tpr );
		assertEquals(pr, tpr);
		System.out.println("Validation complete");
		
	}
}





