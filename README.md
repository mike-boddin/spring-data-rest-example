# spring-data-rest-example
Showcase for a problem with @RepositoryRestController


``

``curl 'http://localhost:8080/api/example/test' -i -H 'Accept: application/hal+json'``

		HTTP/1.1 404 Not Found
		Content-Type: application/hal+json;charset=UTF-8
		
		{"timestamp":1458559309844,"status":404,"error":"Not Found","message":"No message available","path":"/api/example/test"}

``curl 'http://localhost:8080/rest/test' -i -H 'Accept: application/hal+json'``

		HTTP/1.1 200 OK
		Content-Type: application/hal+json;charset=UTF-8

		{}

