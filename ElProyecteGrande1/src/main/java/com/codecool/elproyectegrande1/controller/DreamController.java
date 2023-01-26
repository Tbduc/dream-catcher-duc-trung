package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.DreamDto;
import com.codecool.elproyectegrande1.dto.NewDreamDto;
import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dreams")
public class DreamController {

    private final DreamService dreamService;

    @Autowired
    public DreamController(DreamService dreamService) {
        this.dreamService = dreamService;
    }

    @PostMapping
    public DreamDto createNewDream(@RequestBody NewDreamDto newDreamDto) {
        return dreamService.addDream(newDreamDto);
    }

    @GetMapping("/{id}")
    public DreamDto getDreamById(@PathVariable("id") Long id) {
        return dreamService.getDreamById(id);
    }


    @PutMapping("/{id}/like")
    public void likeDream(@PathVariable Long id) {
        dreamService.likeDream(id);
    }

    @GetMapping("/most-liked")
    public Dream getDreamWithMostLikes() {
        return dreamService.getDreamWithMostLikes();
    }
}