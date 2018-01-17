package com.codekul.GrapprApp.repo

import com.codekul.GrapprApp.domain.Apps
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by pooja on 30/12/17.
 */
interface AppsRepo:MongoRepository<Apps,String> {

    override fun findAll():List<Apps>

    fun findByCategory(category:String):List<Apps>

}