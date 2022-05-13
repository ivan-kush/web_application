package com.calculator.web.repo;

import com.calculator.web.models.article;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<article, Long> {
}
