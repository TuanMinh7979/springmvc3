package com.mvc.service;

import com.mvc.model.AppUser;

public interface IAppUserService {
    AppUser getUserByUserName(String name);
}
