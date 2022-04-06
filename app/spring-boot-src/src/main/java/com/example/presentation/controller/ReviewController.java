package com.example.presentation.controller;

import com.example.usecase.SearchReviewUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private SearchReviewUseCase searchReviewUseCase;

    @GetMapping("/")
    public String getReviewsByPage(@RequestParam(name="p",required=false,defaultValue = "1") Integer pageNum) {
        return searchReviewUseCase.getByPage(pageNum);
    }

    @GetMapping("/user/{userId}/")
    public String searchReviewsByUserId(@PathVariable("userId") Integer userId,
                                        @RequestParam(name="p",required=false,defaultValue = "1") Integer pageNum) {
        return searchReviewUseCase.searchByUserId(userId, pageNum);
    }

    /* 追加予定機能
    @GetMapping("/keyword/")
    public String searchReviewsByKeyword(@RequestParam(name="p",required=false,defaultValue = "1") Integer pageNum,
                                         @RequestParam(name="q",required=false,defaultValue = "") String query) {
        return searchReviewUseCase.searchByKeyword(query,pageNum);
    }
    */
}
