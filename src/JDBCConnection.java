import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bhargav\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
String host="localhost";
String port="3306";
Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/demo", "root", "root");
Statement s=con.createStatement();
ResultSet rs=s.executeQuery("select * from credentials where scenario='outbalancecard'");
while(rs.next()) 
{
	
		driver.get("https://login.salesforce.com/");
driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("passowrd"));
driver.findElement(By.xpath(".//*[@id='Login']")).click();
}
ResultSet rs1=s.executeQuery("select * from credentials where scenario='zerobalanced'");
while(rs1.next()) {
driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs1.getString("username"));
driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs1.getString("passowrd"));
driver.findElement(By.xpath(".//*[@id='Login']")).click();
System.out.println(driver.getTitle());
driver.close();

}



	}

}
