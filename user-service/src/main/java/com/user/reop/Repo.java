package com.user.reop;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.model.User;

@Repository
public interface Repo extends MongoRepository<User,String> {



}
