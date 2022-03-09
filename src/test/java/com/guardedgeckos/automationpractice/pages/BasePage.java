package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage {
    protected static String DEFAULT_URL = "http://automationpractice.com/index.php";
    protected static WebDriver driver;
    private By banner = new By.ByClassName("img-responsive");
    private By shopPhone = new By.ByClassName("shop-phone");
    private By contactUs = new By.ById("contact-link");
    private By signIn = new By.ByClassName("login");
    private By sigOut = new By.ByClassName("logout");
    private By account = new By.ByClassName("account");
    private By yourLogoImg = new By.ByXPath("//*[@id='header_logo']/a/img");
    private By searchBox = new By.ById("search_query_top");
    private By buttonSearchBox = new By.ById("searchbox");
    private By cart = new By.ByClassName("shopping_cart");
    private By productsList = new By.ByClassName("products");
    private By checkoutButton = new By.ByClassName("button_order_cart");
    private By categoriesHeader = By.xpath("//div[@class='sf-menu clearfix menu-content']");
    private By womenHeader = new By.ByCssSelector("title='Women'");
    private By dressesHeader = new By.ByCssSelector("title='Dresses'");
    private By tshirtsHeader = new By.ByCssSelector("title='T-shirts'");
    private By newsletterBox = new By.ById("newsletter-input");
    private By newsletterButton = new By.ByXPath("//*[@id='newsletter_block_left']/div/form/div/button");
    private By facebook = new By.ByClassName("facebook");
    private By twitter = new By.ByClassName("twitter");
    private By youtube = new By.ByClassName("youtube");
    private By googlePlus = new By.ByClassName("google-plus");
    private By categoriesFooter = new By.ByXPath("//*[@id='footer']/div/section[2]/div/div/ul");
    private By informationFooter  = new By.ByXPath("//*[@id='block_various_links_footer']/ul");
    private By myAccountFooter = new By.ByXPath("//*[@id='footer']/div/section[5]/div");
    private By storeInformationFooter = new By.ById("block_contact_infos");


    protected BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get(DEFAULT_URL);
    }

    protected BasePage(WebDriver driver, String url)
    {
        this.driver = driver;
        this.driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getDefaultUrl()
    {
        return DEFAULT_URL;
    }

    // Header

    public void bannerURL() {
        try {
            this.driver.findElement(banner).getAttribute("img");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String businessPhoneNumber() {
        try {
            Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{3}-[0-9]{3}");
            Matcher matcher = pattern.matcher(this.driver.findElement(shopPhone).getText());
            return matcher.group(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void getContactUs() {
        try {
            this.driver.findElement(contactUs).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSigIn() {
        try {
            this.driver.findElement(signIn).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSigOut() {
        try {
            driver.findElement(sigOut).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAccount() {
        try {
            driver.findElement(account).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHomePage() {
        try {
            this.driver.findElement(yourLogoImg).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSearchBox(String word) {
        try {
            this.driver.findElement(searchBox).sendKeys(word);
            this.driver.findElement(buttonSearchBox).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCart() {
        try {
            this.driver.findElement(cart).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void productsListCart() {
        try {
            this.driver.findElement(productsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkoutButtonCart() {
        try {
            this.driver.findElement(checkoutButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavWomen() {
        try {
            this.driver.findElement(categoriesHeader).findElement(womenHeader).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavDresses() {
        try {
            this.driver.findElement(categoriesHeader).findElement(dressesHeader).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavTShirts() {
        try {
            this.driver.findElement(categoriesHeader).findElement(tshirtsHeader).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Footer

    public void subscribeNewsletter(String email) {
        try {
            this.driver.findElement(newsletterBox).sendKeys(email);
            this.driver.findElement(newsletterButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getFacebook() {
        try {
            this.driver.findElement(facebook).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTwitter() {
        try {
            this.driver.findElement(twitter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getYoutube() {
        try {
            this.driver.findElement(youtube).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getGooglePlus() {
        try {
            this.driver.findElement(googlePlus).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> getCategoriesFooter() {
        List<WebElement> catFooter = new ArrayList<>();
        try {
            catFooter = this.driver.findElements(categoriesFooter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catFooter;
    }

    public List<WebElement> getInformationFooter() {
        List<WebElement> infFooter = new ArrayList<>();
        try {
            infFooter = this.driver.findElements(informationFooter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infFooter;
    }

    public void myAccountFooter() {
        try {
            this.driver.findElement(myAccountFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> getMyAccountFooter() {
        List<WebElement> accountFooter = new ArrayList<>();
        try {
            accountFooter = this.driver.findElements(myAccountFooter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountFooter;
    }

    public List<WebElement> getStoreInformationFooter() {
        List<WebElement> storeInfFooter = new ArrayList<>();
        try {
            storeInfFooter = this.driver.findElements(storeInformationFooter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeInfFooter;
    }
}
