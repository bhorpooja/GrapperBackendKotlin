package com.codekul.GrapprApp.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by pooja on 5/1/18.
 */
class Admin (){
    @Id val id:String?=null
    @Field lateinit var name:String
    @Field lateinit var password:String
    constructor(name:String,password:String):this(){
        this.name=name
        this.password=password
    }
}