# Rest-Service

Movie quiz REST service built on top of themoviedb.org api:

https://www.themoviedb.org/documentation/api


# Sample Output

GET movie-quiz/year-of-release-quiz

```json
{
	"id":37799,
	"name":"The Social Network",
	"imagePath":"http://image.tmdb.org/t/p/original/lpn1whaulslRtxxufxX9lhEQ0Bn.jpg",
	"choices":[2007,2010,2013]
}
```

GET movie-quiz/answer-year-of-release-quiz?movieId=37799&year=2010

```json
{
  "correct":true
}
```

# Status

[![owalshe](https://circleci.com/gh/owalshe/Rest-Service.svg?style=shield)](https://app.circleci.com/pipelines/github/owalshe)

