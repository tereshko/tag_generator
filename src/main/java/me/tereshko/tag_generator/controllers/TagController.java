package me.tereshko.tag_generator.controllers;

import lombok.RequiredArgsConstructor;
import me.tereshko.tag_generator.services.TagServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/generator")

public class TagController {

    private final TagServices tagServices;

//    @GetMapping("/api/v1/generator")
    @GetMapping()
    public ResponseEntity<?> getRandomTags(@RequestParam(defaultValue = "0") int tagsExisted) {
        Map<String, Object> response = new HashMap<>();

        if (tagsExisted == 0) {
            response.put("General", tagServices.getRandomTagsBySectionAndCount(1L, 15));
        } else {
            response.put("General", tagServices.getRandomTagsBySectionAndCount(1L, 15 - tagsExisted));
        }

        response.put("Personal", tagServices.getRandomTagsBySectionAndCount(2L, 3));
        response.put("Graphic", tagServices.getRandomTagsBySectionAndCount(3L, 5));
        response.put("Botanical", tagServices.getRandomTagsBySectionAndCount(4L, 5));
        response.put("Location", tagServices.getRandomTagsBySectionAndCount(5L, 2));

        return ResponseEntity.ok(response);
    }

//    @GetMapping("/api/v1/getalltags")
//    public List<Tags> getAllTags() {
//        return tagServices.findAllTags();
//    }
//
//    @GetMapping("/api/v1/getalltags1")
//    public List<Tags> getBySections() {
//        return tagServices.getRandomTagsBySectionAndCount(1L, 15);
//    }
}
