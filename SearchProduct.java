import org.junit.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchProduct
{
    protected WebDriver driver ;
    @Before
    public void Init()
    {
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\driver\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","E:\\selenium\\driver\\geckodriver.exe");
        driver =new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tiki.vn/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



    }


@Test
    public void searchProduct()
    {
        String expResult="";
        String sTensp="Tai nghe Asus ROG Cetra Core in-ear - Hàng Chính Hãng";
        String sGiasp="763.000 ₫";

        driver.findElement(By.xpath("//input[@data-view-id='main_search_form_input']")).sendKeys("ASUS");;

        driver.findElement(By.xpath("//button[@data-view-id='main_search_form_button']")).click();;

        //driver.findElement(By.xpath("//img[@src='https://salt.tikicdn.com/cache/280x280/ts/product/12/a2/96/87eda0599fd56bbc766629f30e0da874.jpg']")).click();
        driver.findElement(By.xpath("//img[@alt='Tai nghe Asus ROG Cetra Core in-ear - Hàng Chính Hãng']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();

       Boolean Anhsp=driver.findElement(By.xpath("//div[@class='container']//div//div//img")).isDisplayed();

       Assert.assertEquals(true,Anhsp);
        String Tensp=driver.findElement(By.xpath("//div[@class='header']//h1[@class='title']")).getText();
        Assert.assertEquals(sTensp,Tensp);
        String Giasp=driver.findElement(By.xpath("//div[@class='product-price']//span[@class='product-price__current-price']")).getText();

        Assert.assertEquals(sGiasp,Giasp);
        String bntChonmua=driver.findElement(By.xpath("//button[@data-view-id='pdp_add_to_cart_button']")).getText();
        Assert.assertEquals("Chọn Mua",bntChonmua);

    }


    @After
    public void closeBrowser() {

        driver.close();
    }

}
