package net.autorisiert.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ExampleRestController
{

    @RequestMapping("/test")
    public Map<String, String> test()
    {
        return new HashMap<>();
    }
}
