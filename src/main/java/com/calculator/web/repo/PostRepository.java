package com.calculator.web.repo;

import com.calculator.web.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Article, Long> {
}
