package com.codekul.GrapprApp.domain

/**
 * Created by pooja on 4/1/18.
 */
class AppStatus(){
    lateinit var id:String
    lateinit var name:String
    var install:Boolean = false
    var uninstall:Boolean=false
    var skip:Boolean=false
    constructor(id: String,name: String,install: Boolean,uninstall: Boolean,skip: Boolean):this(){
        this.id=id
        this.name=name
        this.install=install
        this.uninstall=uninstall
        this.skip=skip
    }
}