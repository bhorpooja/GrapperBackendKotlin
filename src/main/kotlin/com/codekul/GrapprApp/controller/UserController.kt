package com.codekul.GrapprApp.controller

import com.codekul.GrapprApp.domain.User
import com.codekul.GrapprApp.repo.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.HashMap

/**
 * Created by pooja on 4/1/18.
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userRepo:UserRepo

    val STATUS = "status"
    val FAIL = "failure"
    val EXCEPTION="exception"
    val SUCCESS = "success"
    val MESSAGE = "msg"
    val RESULT="result"

    internal var map: MutableMap<String, Any> = HashMap()
    internal var entity: ResponseEntity<Map<String, Any>>? = null

    @PostMapping("/registerUser")
    fun registerUser(@RequestBody user: User): ResponseEntity<Map<String, Any>>? {
        try {
            val user = User(user.name, user.mobileNo, user.pwd)
            userRepo.save(user)
            map.put(STATUS, SUCCESS)
            map.put(MESSAGE, "User Register Successfully")
            map.put(RESULT, user)
            entity = ResponseEntity<Map<String, Any>>(map, HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
        return entity
    }

    @GetMapping("/getUser")
    fun getUser(): ResponseEntity<Map<String, Any>>?{
        try {
            val users = userRepo.findAll()
            map.put(STATUS, SUCCESS)
            map.put(RESULT, users)
            entity = ResponseEntity<Map<String, Any>>(map, HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
        return entity
    }

    @GetMapping("/getUserById/{id}")
    fun getUserById(@PathVariable id:String): ResponseEntity<Map<String, Any>>?{
        try {
            val user = userRepo.findById(id)
            map.put(STATUS, SUCCESS)
            map.put(RESULT, user)
            entity = ResponseEntity<Map<String, Any>>(map, HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
        return entity
    }

    @PostMapping("/updateUserById/{id}")
    fun updateById(@PathVariable id:String,@RequestBody user:User):ResponseEntity<Map<String, Any>>?{
        try {
            val user1: User = userRepo.findById(id)
            user1.installedApps = user.installedApps
            user1.uninstalledApps = user.uninstalledApps
            user1.skipedApps = user.skipedApps
//        val items=ArrayList<AppStatus>()
//        val list=user.installedApps
//
//        /*Using Constructor*/
//        list?.forEach {
//            app-> AppStatus(app.id,app.name,app.install,app.uninstall,app.skip)
//            items.add(app)
//        }

            /**/
//        var status=AppStatus()
//        list?.forEach { app->
//            status.id = app.id
//            status.name = app.name
//            status.install = app.install
//            status.uninstall = app.uninstall
//            status.skip = app.skip
//            items.add(status)
//        }

            /*set values manually*/
//        var status=AppStatus()
//            status.id = "123456"
//            status.name = "Share Market"
//            status.install = false
//            status.uninstall = false
//            status.skip =false
//        items.add(status)

//        user1.appStatus=items
            userRepo.save(user1)
            map.put(STATUS, SUCCESS)
            map.put(MESSAGE, "User updated Successfully")
            map.put(RESULT, user)
            entity = ResponseEntity<Map<String, Any>>(map, HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
       return entity
    }
}