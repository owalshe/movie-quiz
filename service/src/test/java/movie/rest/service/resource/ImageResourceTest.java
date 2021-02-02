package movie.rest.service.resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import movie.quiz.model.resource.DefaultImage;
import movie.quiz.service.ApiKeyHandler;
import movie.quiz.service.resource.MovieImageResource;
import movie.quiz.service.resource.request.ImageResourceRequest;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {MovieImageResource.class, ApiKeyHandler.class})
class ImageResourceTest {

	@Autowired
	private MovieImageResource imageResource;
	
	@Test
	void test() throws Exception {
		DefaultImage image = this.imageResource.get(new ImageResourceRequest(8872));
		BufferedImage bufferedImage = ImageIO.read(new URL(image.getPath()));
		assertNotNull(bufferedImage);
	}
}
