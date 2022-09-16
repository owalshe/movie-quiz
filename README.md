# Service

Movie quiz service built on top of themoviedb.org api:

https://www.themoviedb.org/documentation/api

# Setup
- Compile at root using "mvn clean install".
- Navigate to service folder and run "mvn spring-boot:run" to start service.
- Use Postman or other client to interact with service.

# Sample Output

POST quiz/movie/year-of-release

```json
{
	"id":37799,
	"name":"The Social Network",
	"imagePath":"http://image.tmdb.org/t/p/original/lpn1whaulslRtxxufxX9lhEQ0Bn.jpg",
	"choices":[2007,2010,2013]
}
```

GET quiz/movie/year-of-release/answer?movieId=37799&year=2010

```json
{
  "correct":true
}
```

