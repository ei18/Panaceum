package com.riwi.panaceum.infraestructure.abstract_services;

import com.riwi.panaceum.api.dto.request.UserRequest;
import com.riwi.panaceum.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, Long>{
    public final String FIELD_BY_SORT = "email";
}
