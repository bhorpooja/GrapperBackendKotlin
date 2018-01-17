package com.codekul.GrapprApp.controller

import com.codekul.GrapprApp.domain.Apps
import com.codekul.GrapprApp.repo.AppsRepo
import com.codekul.GrapprApp.util.DateFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.HashMap

/**
 * Created by pooja on 30/12/17.
 */
@RestController
@RequestMapping("/apps")
@CrossOrigin("*")
class AppsController {

    @Autowired
    lateinit var appsRepo:AppsRepo

    val STATUS = "status"
    val FAIL = "failure"
    val EXCEPTION="exception"
    val SUCCESS = "success"
    val MESSAGE = "msg"
    val RESULT="result"

    internal var map: MutableMap<String, Any> = HashMap()
    internal var entity: ResponseEntity<Map<String, Any>>? = null

//    @PostMapping("/saveApps")
//    fun saveApps(@RequestParam name:String,
//                 @RequestParam category:String,
//                 @RequestParam offer:Double,
//                 @RequestParam image:MultipartFile): ResponseEntity<Map<String, Any>>? {
//
//        val file1 = File("/home/pooja/Desktop/Images/" + image.originalFilename)
//        image.transferTo(file1)
//        val path=file1.absolutePath
//        val apps=Apps(name,category,offer,path)
//        appsRepo.save(apps)
//        map.put(STATUS, SUCCESS)
//        map.put(MESSAGE, "App saved")
//        map.put("app", apps)
//        entity = ResponseEntity<Map<String, Any>>(map, HttpStatus.OK)
//        return entity
//    }

    @PostMapping("/saveApps")
    fun saveApps(@RequestBody apps: Apps): ResponseEntity<Map<String, Any>>?{
        try {
            val currentDate=DateFormat().getFormatedDate( System.currentTimeMillis())
            val apps=Apps(apps.appName!!, apps.url!!,apps.offer, apps.category!!,currentDate)
            appsRepo.save(apps)
            map.put(STATUS, SUCCESS)
            map.put(MESSAGE, "App saved")
            map.put(RESULT, apps)
            entity = ResponseEntity(map, HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
        return entity

    }

    @GetMapping("/getApps")
    fun getApps():ResponseEntity<Map<String, Any>>?{
        try {
            val apps = appsRepo.findAll(Sort(Sort.Direction.DESC,"offer"))
            map.put(STATUS, SUCCESS)
            map.put(MESSAGE,"Get All Apps")
            map.put(RESULT, apps)
            entity = ResponseEntity(map, HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
        return entity
    }

    @GetMapping("/getAppsByCategory/{category}")
    fun getAppsByCategory(@PathVariable category:String):ResponseEntity<Map<String,Any>>?{
        try {
            val apps=appsRepo.findByCategory(category)
            map.put(STATUS,SUCCESS)
            map.put(MESSAGE,"get Category Apps")
            map.put(RESULT,apps)
            entity= ResponseEntity(map,HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
        return entity
    }

    @DeleteMapping("/deleteApp/{id}")
    fun deleteApp(@PathVariable id:String):ResponseEntity<Map<String,Any>>?{
        try {
            appsRepo.delete(id)
            map.put(STATUS, SUCCESS)
            map.put(MESSAGE, "App deleted Successfully")
            map.put(RESULT,"true")
            entity = ResponseEntity(map, HttpStatus.OK)
        }
        catch (ex:Exception){
            map.put(STATUS,FAIL)
            map.put(EXCEPTION,ex)
            entity= ResponseEntity(map,HttpStatus.BAD_REQUEST)
        }
        return entity
    }
}