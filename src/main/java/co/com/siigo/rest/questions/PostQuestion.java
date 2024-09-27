package co.com.siigo.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
public class PostQuestion implements Question<Boolean> {

    private List<String>  dataUserCreate;

    public PostQuestion(List<String>  dataUserCreate) {
        this.dataUserCreate = dataUserCreate;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("Validate Data Response",
                        r -> r.body("name", equalTo(dataUserCreate.get(0)))
                               .body("job", equalTo(dataUserCreate.get(1)))
                )
        );
        return true;
    }

    public static PostQuestion registerSuccess(List<String> dataUserCreate) {
        return new PostQuestion(dataUserCreate);
    }
}
