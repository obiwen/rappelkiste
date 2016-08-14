package rappelkiste

import com.jayway.restassured.RestAssured
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static com.jayway.awaitility.Awaitility.await
import static org.hamcrest.Matchers.containsString

class BasicSpec extends SetupSpec {

    static final Logger logger = LoggerFactory.getLogger(BasicSpec.class);

    def "lets ping the two services"(String url) {

        given: "Two servers running locally on 8080 and 8081"

        when: "The Ping services are queried"

        then: "expect a pong in the body"
        logger.debug("Testing url: " + url)
        await().ignoreExceptions().until({
            RestAssured.get(url).then().assertThat().body(containsString("pong"))
        })

        where:
            url << ["localhost:8080", "localhost:8081"]

    }
}
