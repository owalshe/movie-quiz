package movie.rest.service.resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import movie.quiz.model.resource.DefaultMovie;
import movie.quiz.service.ApiKeyHandler;
import movie.quiz.service.resource.RandomMovieResource;
import movie.quiz.service.resource.request.RandomMovieResourceRequest;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {RandomMovieResource.class, ApiKeyHandler.class})
class RandomMovieResourceTest {

	@Autowired
	private RandomMovieResource randomMovieGenerator;
	
	@Test
	void test() throws Exception {
		DefaultMovie build = this.randomMovieGenerator.get(new RandomMovieResourceRequest());
		assertNotNull(build);
	}
	
}
