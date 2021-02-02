package movie.quiz.api.resource;

import movie.quiz.api.model.Resource;

public interface ResourceProvider<P extends Resource, R extends ResourceRequest> {

	P get(R request) throws ResourceException;
}
