package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Dasveneba {
    private SelenideElement dasvenebaButton = $(".cat-2"),
    minPriceField = $("#minprice"),
    maxPriceField = $("#maxprice");

    public void OpenDasveneba() {
        Selenide.open("");
        dasvenebaButton.click();
    }

    public SelenideElement GetMinPriceField(){
        return minPriceField;
    }

    public void FillPriceFilter(String minPrice, String maxPrice){
        minPriceField.setValue(minPrice);
        maxPriceField.setValue(maxPrice);
    }
}
