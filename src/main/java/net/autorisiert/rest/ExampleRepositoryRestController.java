package net.autorisiert.rest;

import java.util.HashMap;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequestMapping("/example")
public class ExampleRepositoryRestController
{

    @RequestMapping("/test")
    public @ResponseBody ResponseEntity<?> test()
    {
        return ResponseEntity.ok(new HashMap<>());
    }
}
