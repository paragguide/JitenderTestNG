package testcases;

import static utility.MakeConnectionPOI.getData;
import static utility.Report.report;
import static utility.Report.test;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class ProductSearchTest extends Hook
{
	
  @Test(dataProvider = "getdata",priority = 1, dependsOnGroups= {"login"})
  public void searchProducts(String productname) throws Exception 
  {
	  test = report.createTest("search Product Test");
	  searchtxtbox.clear();
	  searchtxtbox.sendKeys(productname);
	  
	  test.log(Status.PASS, MarkupHelper.createLabel("searching for .."+productname, ExtentColor.GREEN));
	  
	  Actions a = new Actions(driver);
	  a.sendKeys(Keys.ENTER).perform();
	   Thread.sleep(4000);
	  searchResult();  
  }
  
  @DataProvider
  public String[][] getdata() throws Exception
  {
	  return getData("AmazonLogin","Sheet2");
  }
  
  public void searchResult()
  {
	  test = report.createTest("search result ");
	Iterator <WebElement> it =  searchresult.iterator();
	
	 for(int i =1; i <= 5; i++)
	 {
		WebElement e = it.next();
	String dsp =	e.getText();
	test.log(Status.PASS, MarkupHelper.createLabel("searchresult .."+dsp, ExtentColor.GREEN));
	  
	 }
  }
}
