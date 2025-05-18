package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActorPage;
import pages.TitleDetailsPage;
import pages.components.SearchBar;

import static com.codeborne.selenide.Selenide.*;

public class ImdbTests {

    @Test
    public void testImdb() {

        // Open imdb.com
        open("https://www.imdb.com");

        SearchBar searchBar = new SearchBar();

        // Search for "QA" with the search bar
        searchBar.search("QA");

        // When dropdown opens, save the name of the first title
        String firstSearchResult = searchBar.getResultTitle(0);

        // Click on the first title
        TitleDetailsPage titleDetailsPage = searchBar.openResult(firstSearchResult);

        // Verify that page title matches the one saved from the dropdown
        Assert.assertTrue(title().contains(firstSearchResult),
                "Title mismatch. Expected: " + firstSearchResult + " but was: " + title());

        // Verify there are more than 3 members in the "top cast section"
        int topCastCount = titleDetailsPage.getTopCastCount();
        Assert.assertTrue(topCastCount > 3,
                "Expected more than 3 top cast members, but found: " + topCastCount);

        // Click on the 3rd profile in the "top cast section"
        String thirdActorName = titleDetailsPage.getActorName(2);
        ActorPage actorPage = titleDetailsPage.openActorPage(thirdActorName);

        // Verify that correct profile have opened
        Assert.assertEquals(actorPage.getActorName(), thirdActorName);
    }
}
