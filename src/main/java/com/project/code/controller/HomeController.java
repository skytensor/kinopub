package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
public class HomeController {
    private final MovieRepository movieRepository;

    private static final Sort BY_YEAR_DESC =
            Sort.by(Sort.Order.desc("year"), Sort.Order.desc("id"));

    @GetMapping("/")
    public String home(Model model) {
        Page<Movie> movies = movieRepository.findAll(PageRequest.of(0, 14, BY_YEAR_DESC));
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String query,
            Model model) {

        String q = query.strip();
        if (q.isEmpty()) {
            return "redirect:/movies";
        }

        Page<Movie> result = movieRepository.findByTitleContainingIgnoreCase(q, PageRequest.of(Math.max(page, 0), 21, BY_YEAR_DESC));

        model.addAttribute("query", q);
        addPagination(model, result);
        return "search";
    }

    @GetMapping("/movies")
    public String movies(
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Page<Movie> result = movieRepository.findAll(PageRequest.of(Math.max(page, 0), 21, BY_YEAR_DESC));
        addPagination(model ,result);
        return "allMovies";
    }

    private void addPagination(Model model, Page<Movie> page) {
        int total = page.getTotalPages();
        int last = Math.max(0, total - 1);
        int current = Math.min(page.getNumber(), last);

        model.addAttribute("movies", page.getContent());
        model.addAttribute("currentPage", current);
        model.addAttribute("totalPages", total);
        model.addAttribute("startPage", Math.max(0, current - 2));
        model.addAttribute("endPage", Math.min(last, current + 2));
    }
}
