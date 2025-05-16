package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TitleDetailsPage {
    String actorNameSelector = "a[data-testid='title-cast-item__actor']";

    public int getTopCastCount() {
        $("section[data-testid='title-cast']").shouldBe(visible);
        return $$(actorNameSelector).size();
    }

    public String getActorName(int index) {
        return $$(actorNameSelector).get(index - 1).text();
    }

    public ActorPage openActorPage(String actorName) {
        $$(actorNameSelector).findBy(text(actorName)).scrollTo().click(); // throws 'element click intercepted', if not in viewport
        return new ActorPage();
    }
}
