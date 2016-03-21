# spring-data-rest-example
Showcase for a problem with ``@RepositoryRestController`` and ``@BasePathAwareController``.

## Problem 1

On application start you will see:



		INFO 13840 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/example/test]}" onto public java.util.Map<java.lang.String, java.lang.String> net.autorisiert.rest.ExampleRepositoryRestController.test()
		INFO 13840 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/rest/test]}" onto public java.util.Map<java.lang.String, java.lang.String> net.autorisiert.rest.ExampleRestController.test()
		
		...
		
		INFO 13840 --- [           main] o.s.d.r.w.RepositoryRestHandlerMapping   : Mapped "{[/api/example/test],produces=[application/hal+json || application/json || application/*+json;charset=UTF-8]}" onto public java.util.Map<java.lang.String, java.lang.String> net.autorisiert.rest.ExampleRepositoryRestController.test()
		



``ExampleRestController`` works as expected:

``curl 'http://localhost:8080/rest/test' -i -H 'Accept: application/hal+json'``

		HTTP/1.1 200 OK
		Content-Type: application/hal+json;charset=UTF-8
		
		{}

``ExampleRepositoryRestController`` does not...


``curl 'http://localhost:8080/api/example/test' -i -H 'Accept: application/hal+json'``

		HTTP/1.1 404 Not Found
		Content-Type: application/hal+json;charset=UTF-8
				
		{"timestamp":1458559309844,"status":404,"error":"Not Found","message":"No message available","path":"/api/example/test"}
		
but this will work:


``curl 'http://localhost:8080/example/test' -i -H 'Accept: application/hal+json'``

		HTTP/1.1 200 OK
		Content-Type: application/hal+json;charset=UTF-8
		
		{}

## Solution for problem 1

Endpoints of ``ExampleRepositoryRestController`` are not exposed, because there is no repository loaded which maps to ``example`` (as mentioned here:  http://docs.spring.io/spring-data/rest/docs/current/reference/html/#_repositoryresthandlermapping ).

This is OK, so let's try it with ``@BasePathAwareController`` which is implemented in ``ExampleBasePathAwareController``:

``curl 'http://localhost:8080/api/base/test' -i -H 'Accept: application/hal+json'``

		HTTP/1.1 200 OK
		Content-Type: application/hal+json;charset=UTF-8
		
		{}
		
OK, fine this works as expected.

But now we have this odd ...

## Problem 2

The endpoints of ``ExampleBasePathAwareController`` are also mapped at root-context:

``curl 'http://localhost:8080/base/test' -i -H 'Accept: application/hal+json'``

		HTTP/1.1 200 OK
		Content-Type: application/hal+json;charset=UTF-8
		
		{}

This should not happen and I do not have a clue, how to prevent this mapping. 

