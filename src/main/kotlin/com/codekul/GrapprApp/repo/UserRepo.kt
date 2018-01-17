package com.codekul.GrapprApp.repo

import com.codekul.GrapprApp.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by pooja on 4/1/18.
 */
interface UserRepo:MongoRepository<User,String> {

    fun findById(id:String):User
}