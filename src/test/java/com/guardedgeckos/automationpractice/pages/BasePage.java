package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage {
    public static String DEFAULT_URL = "http://automationpractice.com/index.php";
    protected static WebDriver driver;
    private Actions action;

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

    private By cartHovered = new By.ByXPath("//*[@id='header']/div[3]/div/div/div[3]/div/a");
    private By itemImageLinkCart = new By.ByClassName("cart-images");
    private By totalQuantityCart = new By.ByClassName("ajax_cart_quantity");
    private By quantityItemCart = new By.ByClassName("quantity");
    private By itemNameLinkCart = new By.ByClassName("cart_block_product_name");
    private By productDetailsCart = new By.ByCssSelector("title=Product detail'");
    private By itemPriceCart = new By.ByClassName("price");
    private By removeItemCart = new By.ByClassName("ajax_cart_block_remove_link");
    private By checkOutButtonHovered = new By.ByXPath("//*[@id='button_order_cart']/span");
    private By shippingFeesCartHovered = new By.ByXPath("//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/div/div[2]/span[1]");
    private By totalCartHovered = new By.ByXPath("//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/div/div[1]/span[1]");

    private By categoriesHeader = new By.ByXPath("//*[@id='block_top_menu']/ul");

    private By womenHeader = new By.ByCssSelector("title='Women'");
    private By tshirtWomenHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a");
    private By blousesWomenHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a");
    private By casualDresserWomenHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a");
    private By eveningDressesWomenHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[2]/a");
    private By summerDressesWomenHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a");
    private By dressesHeader = new By.ByCssSelector("title='Dresses'");
    private By casualDressesHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a");
    private By eveningDressesHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a");
    private By summerDressesHeader = new By.ByXPath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a");
    private By tshirtsHeader = new By.ByCssSelector("title='T-shirts'");

    private By newsletterBox = new By.ById("newsletter-input");
    private By newsletterButton = new By.ByXPath("//*[@id='newsletter_block_left']/div/form/div/button");

    private By facebook = new By.ByClassName("facebook");
    private By twitter = new By.ByClassName("twitter");
    private By youtube = new By.ByClassName("youtube");
    private By googlePlus = new By.ByClassName("google-plus");

    private By myAccountFooter = new By.ByXPath("//*[@id='footer']/div/section[5]/div");

    private By womenFooter = new By.ByXPath("//*[@id='footer']/div/section[2]/div/div/ul/li/a");

    private By specialsFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[1]/a");
    private By newProductsFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[2]/a");
    private By bestSellersFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[3]/a");
    private By ourStoresFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[4]/a");
    private By contactUsFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[5]/a");
    private By termsFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[6]/a");
    private By aboutUsFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[7]/a");
    private By siteMapFooter = new By.ByXPath("//*[@id='block_various_links_footer']/ul/li[8]/a");

    private By myOrdersFooter = new By.ByXPath("//*[@id='footer']/div/section[5]/div/ul/li[1]/a");
    private By creditSlipsFooter = new By.ByXPath("//*[@id='footer']/div/section[5]/div/ul/li[2]/a");
    private By addressesFooter = new By.ByXPath("//*[@id='footer']/div/section[5]/div/ul/li[3]/a");
    private By personalInfoFooter = new By.ByXPath("//*[@id='footer']/div/section[5]/div/ul/li[4]/a");
    private By signOutFooter = new By.ByXPath("//*[@id='footer']/div/section[5]/div/ul/li[5]/a");
    //endregion

    protected BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get(DEFAULT_URL);
        this.action = new Actions(driver);
    }

    protected BasePage(WebDriver driver, String url)
    {
        this.driver = driver;
        this.driver.get(url);
        this.action = new Actions(driver);
    }
    protected BasePage(WebDriver driver, boolean doRefresh)
    {
        this.driver = driver;
        if (doRefresh){
            this.driver.get(DEFAULT_URL);
        }
        this.action = new Actions(driver);
    }


    public String getDefaultUrl () {
        return DEFAULT_URL;
    }

    //region Header
    public void bannerURL () {
        try {
            this.driver.findElement(banner).getAttribute("img");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //region NavBar
    public String businessPhoneNumber () {
        try {
            Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{3}-[0-9]{3}");
            Matcher matcher = pattern.matcher(this.driver.findElement(shopPhone).getText());
            return matcher.group(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void getContactUs () {
        try {
            this.driver.findElement(contactUs).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSigIn () {
        try {
            this.driver.findElement(signIn).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSigOut () {
        try {
            driver.findElement(sigOut).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAccount () {
        try {
            driver.findElement(account).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHomePage () {
        try {
            this.driver.findElement(yourLogoImg).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    public void getSearchBox (String word){
        try {
            this.driver.findElement(searchBox).sendKeys(word);
            this.driver.findElement(buttonSearchBox).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //region Cart
    public void getCart () {
        try {
            this.driver.findElement(cart).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTotalItemsQuantityCart() {
        String totalItemsCart = "";
        try {
            totalItemsCart = this.driver.findElement(totalQuantityCart).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalItemsCart;
    }

    public List<WebElement> getItemsImagesCart() {
        List<WebElement> itemsImages = new ArrayList<>();
        try {
            driver.findElements(itemImageLinkCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsImages;
    }

    public List<WebElement> getItemsQuantitiesCart() {
        List<WebElement> itemsQuantity = new ArrayList<>();
        try {
            driver.findElements(quantityItemCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsQuantity;
    }

    public List<WebElement> getItemsNamesCart() {
        List<WebElement> itemsNames = new ArrayList<>();
        try {
            driver.findElements(itemNameLinkCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsNames;
    }

    public List<WebElement> getItemsDetailsCart() {
        List<WebElement> itemsDetails = new ArrayList<>();
        try {
            driver.findElements(productDetailsCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsDetails;
    }

    public List<WebElement> getItemsPricesCart() {
        List<WebElement> itemsPrices = new ArrayList<>();
        try {
            driver.findElements(itemPriceCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsPrices;
    }

    public List<WebElement> getItemsToRemoveCart() {
        List<WebElement> itemsToRemove = new ArrayList<>();
        try {
            driver.findElements(removeItemCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsToRemove;
    }

    public void getCheckOut () {
        try {
            action.moveToElement(driver.findElement(cartHovered));
            action.moveToElement(driver.findElement(checkOutButtonHovered));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getShippingFeesCartHovered () {
        try {
            action.moveToElement(driver.findElement(cartHovered));
            action.moveToElement(driver.findElement(shippingFeesCartHovered));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTotalCartHovered () {
        try {
            action.moveToElement(driver.findElement(cartHovered));
            action.moveToElement(driver.findElement(totalCartHovered));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region Categories
    public void getNavWomen () {
        try {
            driver.findElement(categoriesHeader).findElement(womenHeader).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavDresses () {
        try {
            driver.findElement(categoriesHeader).findElement(dressesHeader).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTshirtsWomenHeader () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(womenHeader));
            action.moveToElement(driver.findElement(tshirtWomenHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getBlousesWomenHeader () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(womenHeader));
            action.moveToElement(driver.findElement(blousesWomenHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCasualDressesWomenHeader () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(womenHeader));
            action.moveToElement(driver.findElement(casualDresserWomenHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEveningDressesWomenHeader () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(womenHeader));
            action.moveToElement(driver.findElement(eveningDressesWomenHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSummerDressesWomenHeader () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(womenHeader));
            action.moveToElement(driver.findElement(summerDressesWomenHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCasualDresses () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(dressesHeader));
            action.moveToElement(driver.findElement(casualDressesHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEveningDresses () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(dressesHeader));
            action.moveToElement(driver.findElement(eveningDressesHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSummerDresses () {
        try {
            action.moveToElement(driver.findElement(categoriesHeader).findElement(dressesHeader));
            action.moveToElement(driver.findElement(summerDressesHeader));
            action.click().build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavTShirts () {
        try {
            this.driver.findElement(categoriesHeader).findElement(tshirtsHeader).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //endregion

    //region Footer
    public void subscribeNewsletter (String email){
        try {
            this.driver.findElement(newsletterBox).sendKeys(email);
            this.driver.findElement(newsletterButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getFacebook () {
        try {
            this.driver.findElement(facebook).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTwitter () {
        try {
            this.driver.findElement(twitter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getYoutube () {
        try {
            this.driver.findElement(youtube).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getGooglePlus () {
        try {
            this.driver.findElement(googlePlus).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void myAccountFooter () {
        try {
            this.driver.findElement(myAccountFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region FooterWebPageLinks
    public void getWomenFooter () {
        try {
            driver.findElement(womenFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSpecialFooter () {
        try {
            driver.findElement(specialsFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNewProductsFooter () {
        try {
            driver.findElement(newProductsFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getBestSellersFooter () {
        try {
            driver.findElement(bestSellersFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getOurStoresFooter () {
        try {
            driver.findElement(ourStoresFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getContactUsFooter () {
        try {
            driver.findElement(contactUsFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTermsFooter () {
        try {
            driver.findElement(termsFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAboutUsFooter () {
        try {
            driver.findElement(aboutUsFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSiteMapFooter () {
        try {
            driver.findElement(siteMapFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMyOrdersFooter () {
        try {
            driver.findElement(myOrdersFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCreditSlipsFooter () {
        try {
            driver.findElement(creditSlipsFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAddressesFooter () {
        try {
            driver.findElement(addressesFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPersonalInfoFooter () {
        try {
            driver.findElement(personalInfoFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSignOutFooter () {
        try {
            driver.findElement(signOutFooter).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion
}

