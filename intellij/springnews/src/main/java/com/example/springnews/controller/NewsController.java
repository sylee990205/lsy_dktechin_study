package com.example.springnews.controller;

import com.example.springnews.model.News;
import com.example.springnews.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewsController {
    private final NewsRepository repository;

    @GetMapping("/newsmain")
    public String newsList(Model model) {
        List<News> newsList = repository.findAll();
        model.addAttribute("newsList", newsList);
        return "news";
    }

    @GetMapping(value = "listone", produces = "application/json; charset=utf-8")
    @Transactional
    @ResponseBody
    public News showNews(int id) {
        News news = repository.findById(id).get();
        news.setCnt(news.getCnt() + 1);
        return news;
    }

    @GetMapping("/delete")
    @Transactional
    public String delete(Model model, int id) {
        try {
            repository.deleteById(id);
            /*return newsList(model);*/
            return "redirect:/newsmain";
        } catch (Exception e) {
            model.addAttribute("msg", "삭제 중 오류가 발생했습니다.");
        }
        return "news";
    }

    @GetMapping("search")
    public String searchNewsByKeword(Model model, String keyword) {
        List<News> newsList = repository.findByContentContains(keyword);
        model.addAttribute("newsList", newsList);
        return "news";
    }

    @GetMapping("/writer")
    public String searchNewsByWriter(Model model, String writer) {
        List<News> newsList = repository.findByWriter(writer);
        model.addAttribute("newsList", newsList);
        return "news";
    }

    @PostMapping("/insert")
    @Transactional
    public String insert(Model model, News news) {
        try {
            repository.save(news);
            System.out.println(news);
            return "redirect:/newsmain";
        } catch (Exception e) {
            model.addAttribute("msg", "뉴스 작성 중 오류가 발생했습니다.");
        }
        return "news";
    }

    @PostMapping("/update")
    @Transactional
    public String update(Model model, News news){
        System.out.println(news.getId());
        try {
            News oldNews = repository.findById(news.getId()).get();
            oldNews.setWriter(news.getWriter());
            oldNews.setTitle(news.getTitle());
            oldNews.setContent(news.getContent());
            return "redirect:/newsmain";
        } catch (Exception e) {
            model.addAttribute("msg", "뉴스 수정 중 오류가 발생했습니다.");
        }
        return "news";
    }
}
