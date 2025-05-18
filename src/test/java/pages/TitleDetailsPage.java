package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TitleDetailsPage {
    private static final String actorNameSelector = "a[data-testid='title-cast-item__actor']";

    public int getTopCastCount() {
        $("section[data-testid='title-cast']").shouldBe(visible);
        return $$(actorNameSelector).size();
    }

    public String getActorName(int index) {
        return $$(actorNameSelector)
                .get(index)
                .text();
    }

    public ActorPage openActorPage(String actorName) {
        SelenideElement actorNameElement = $$(actorNameSelector).findBy(text(actorName));

        // regular .scrollTo() and .scrollIntoView(true) were flaky
        Selenide.executeJavaScript(
                "arguments[0].scrollIntoView({block: 'start', behavior: 'instant'});",
                actorNameElement
        );

        actorNameElement.shouldBe(visible).click();

        return new ActorPage();
    }
}
