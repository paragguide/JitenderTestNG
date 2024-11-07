package testcases;

import static utility.Report.report;
import static utility.Report.test;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class NewCustomerTest extends Hook
{
  @Test
  public void newcustomer() 
  {
	  test = report.createTest("form fill Test");
	  Actions a = new Actions(driver);
	  a.moveToElement(signin).perform();
	  
	  starthere.click();
	  name.sendKeys("Parag");
	  test.log(Status.PASS, MarkupHelper.createLabel("name added..", ExtentColor.GREEN));
  }
}
