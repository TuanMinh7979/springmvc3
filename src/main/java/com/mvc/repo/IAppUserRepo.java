package com.mvc.repo;

import com.mvc.model.AppUser;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByName(String name);
}
