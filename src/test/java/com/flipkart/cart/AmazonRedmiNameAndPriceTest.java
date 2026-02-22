package com.flipkart.cart;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazon.ObjectRepo.AmazonHomePage;
import com.amazon.ObjectRepo.MobilesPage;
import com.amazon.ObjectRepo.SelectedMobilePage;
import com.flipkart.genericUtility.BaseClass;

public class AmazonRedmiNameAndPriceTest extends BaseClass {

	@Test
	public void nameAndPrice() throws IOException {

		AmazonHomePage hp = new AmazonHomePage(driver);
		hp.searchProduct(eLib.readDataFromExcel("sheet1", 1, 0), wLib, driver);

		MobilesPage mp = new MobilesPage(driver);
		mp.selectBrand(driver, wLib);

		SelectedMobilePage smp = new SelectedMobilePage(driver);
		smp.nameAndPrice(driver, wLib, eLib);
		
	}

}



