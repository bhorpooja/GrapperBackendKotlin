package com.codekul.GrapprApp.repo

import com.codekul.GrapprApp.domain.Admin
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by pooja on 5/1/18.
 */
interface AdminRepo :MongoRepository<Admin,String>{
}