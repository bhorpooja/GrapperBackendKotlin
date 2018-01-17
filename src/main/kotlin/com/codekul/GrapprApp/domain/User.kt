package com.codekul.GrapprApp.domain

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by pooja on 4/1/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class User() {
    @Id val id: String? = null
    @Field lateinit var name:String
    @Field lateinit var mobileNo:String
    @Field lateinit var pwd:String
    @Field var installedApps:List<String>?=null
    @Field var uninstalledApps:List<String>?=null
    @Field var skipedApps:List<String>?=null
    constructor( name: String,pwd:String,mobileNo:String): this(){
        this.name = name
        this.pwd=pwd
        this.mobileNo=mobileNo
    }
}