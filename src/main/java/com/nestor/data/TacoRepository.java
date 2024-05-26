package com.nestor.data;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.nestor.model.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}
