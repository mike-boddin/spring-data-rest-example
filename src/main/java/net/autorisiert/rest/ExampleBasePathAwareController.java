package net.autorisiert.rest;

import java.util.HashMap;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@BasePathAwareController
@RequestMapping("/base")
public class ExampleBasePathAwareController
{
    @RequestMapping("/test")
    public @ResponseBody ResponseEntity<?> test()
    {
        return ResponseEntity.ok(new HashMap<>());
    }
}
