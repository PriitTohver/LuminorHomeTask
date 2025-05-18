package pages.components;

import pages.TitleDetailsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchBar {
    public void search(String text) {
        $("#suggestion-search").type(text);
    }

    public String getResultTitle(int index) {
        return $$(".searchResult__constTitle").get(index).text();
    }

    public TitleDetailsPage openResult(String title) {
        $$("#react-autowhatever-navSuggestionSearch a").findBy(text(title)).click();
        return new TitleDetailsPage();
    }
}
