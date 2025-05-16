package pages;

import static com.codeborne.selenide.Selenide.$;

public class ActorPage {
    public String getActorName() {
        return $("h1").text();
    }
}
