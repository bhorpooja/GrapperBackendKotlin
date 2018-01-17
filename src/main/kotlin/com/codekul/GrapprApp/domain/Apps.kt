package com.codekul.GrapprApp.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field


/**
 * Created by pooja on 30/12/17.
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
 class Apps ()
{
  @Id val id: String? = null
  @Field var appName:String = ""
  @Field var url:String = ""
  @Field var offer:Int=0
  @Field var category:String = ""
  @Field lateinit var date:String
//  @Field val image:String=""

  constructor( name: String,url: String,offers:Int, category:String,date:String): this(){
    this.appName = name
    this.url=url
    this.offer=offers
    this.category=category
    this.date=date

 }
}


