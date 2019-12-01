package com.waracle.cake.repository;

import com.waracle.cake.domain.Cake;
import com.waracle.cake.domain.QCake;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CakeRepository extends PagingAndSortingRepository<Cake, Long>, QuerydslPredicateExecutor<Cake>,
		QuerydslBinderCustomizer<QCake> {

	@Override
	default void customize(QuerydslBindings bindings, QCake cake) {
		bindings.bind(cake.title).first((path, value) -> path.likeIgnoreCase("%" + value + "%"));
		bindings.bind(cake.desc).first((path, value) -> path.likeIgnoreCase("%" + value + "%"));
	}
}
