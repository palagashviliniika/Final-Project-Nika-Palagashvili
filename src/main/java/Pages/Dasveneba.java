package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Dasveneba {
    private SelenideElement dasvenebaButton = $(".cat-2");

    private ElementsCollection minPriceField = $$("#minprice"),
    maxPriceField = $$("#maxprice"),
    searchButton = $$(".submit-button");

    public void OpenDasveneba() {
        Selenide.open("");
        dasvenebaButton.click();
    }

    public SelenideElement GetMinPriceField(){
        return minPriceField.last();
    }

    public void FillPriceFilter(String minPrice, String maxPrice){
        minPriceField.last().setValue(minPrice);
        maxPriceField.last().setValue(maxPrice);
    }

    public void Search(){
        searchButton.last().click();
    }
}
