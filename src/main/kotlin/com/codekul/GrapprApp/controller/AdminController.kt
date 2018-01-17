package com.codekul.GrapprApp.controller

import com.codekul.GrapprApp.domain.Admin
import com.codekul.GrapprApp.repo.AdminRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.HashMap

/**
 * Created by pooja on 5/1/18.
 */

@RestController
@RequestMapping("/admin")
class AdminController {

    @Autowired
    lateinit var adminRepo:AdminRepo

    val STATUS = "status"
    val FAIL = "failure"
    val SUCCESS = "success"
    val MESSAGE = "msg"

    internal var map: MutableMap<String, Any> = HashMap()
    internal var entity: ResponseEntity<Map<String, Any>>? = null

    @PostMapping("/registerAdmin")
    fun saveApps(@RequestBody admin: Admin): ResponseEntity<Map<String, Any>>? {

        val apps= Admin(admin.name,admin.password)
        adminRepo.save(admin)
        map.put(STATUS, SUCCESS)
        map.put(MESSAGE, "Admin registered Successfully")
        map.put("admin", admin)
        entity = ResponseEntity<Map<String, Any>>(map, HttpStatus.OK)
        return entity
    }

}