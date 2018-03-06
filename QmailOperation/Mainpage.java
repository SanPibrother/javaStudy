package QmailOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mainpage {
	private WebDriver driver;
	private WebElement writeLink;
	private WebElement logoutLink;
	
	public Mainpage(WebDriver driver){
		this.driver=driver;
	}
	
	public void toWrite(){
//		writeLink=driver.findElement(By.linkText("写信"));
		writeLink=driver.findElement(By.xpath(".//*[@id='composebtn']"));
		writeLink.click();
	}
	public void toLogout(){
		logoutLink=driver.findElement(By.linkText("退出"));
//		logoutLink=driver.findElement(By.cssSelector("html body.frame_class div#resize div#topDataTd.getuserdata div.topdata div.topbg div#SetInfo.setinfo.addrtitle div.right a.toptitle"));
		logoutLink.click();
	}
}
