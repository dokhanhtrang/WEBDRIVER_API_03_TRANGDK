package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonFunction {
	
	protected static final String JQUERY_ACTIVE_CONNECTIONS_QUERY = null;

	public void waitUntilAjaxRequestCompletes(){
		  WebDriver driver = null;
		new FluentWait<WebDriver>(driver).withTimeout(45,TimeUnit.SECONDS).pollingEvery(15,TimeUnit.SECONDS).until(new ExpectedCondition<Boolean>(){
		  public Boolean apply( WebDriver d){
		  JavascriptExecutor jsExec=(JavascriptExecutor)d;
		  return (Boolean)jsExec.executeScript(JQUERY_ACTIVE_CONNECTIONS_QUERY);
		  }
		  });}
}
