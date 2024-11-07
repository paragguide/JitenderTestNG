package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static utility.Report.*;
import core.Hook;

public class LoginTest extends Hook
{
  @Test(priority=1,groups="login")
  public void useridtest() 
  {
	  test = report.createTest("Userid Test");
	  
	  signin.click();
	  userid.sendKeys("paragguide@yahoo.co.in");
	  ctnbtn.click();
	    try {
	  String txt = err1.getText();
	  test.log(Status.FAIL, MarkupHelper.createLabel("user id is not valid.."+txt, ExtentColor.RED));
	  Assert.fail(txt);
	    }
	    catch(Exception e)
	    {
	    	test.log(Status.PASS, MarkupHelper.createLabel("user id is valid..", ExtentColor.GREEN));
	    }
	  
  }
  
  @Test(priority = 2,groups="login",dependsOnMethods= {"useridtest"})
  public void passwordtest()
  {
	  test = report.createTest("Password Test");
	  password.sendKeys("RMinfotech12#&&");
	  submit.click();
	  
	  try {
		  String txt = err2.getText();
		  test.log(Status.FAIL, MarkupHelper.createLabel("password is not valid.."+txt, ExtentColor.RED));
		  Assert.fail(txt);
		    }
		    catch(Exception e)
		    {
		    	test.log(Status.PASS, MarkupHelper.createLabel("password is valid..", ExtentColor.GREEN));
		    }
	  
  }
}
