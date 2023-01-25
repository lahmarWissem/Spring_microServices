package com.wissem.users.restControllers;

import com.wissem.users.entities.Image;
import com.wissem.users.entities.User;
import com.wissem.users.service.ImageService;
import com.wissem.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImageRestController {

    @Autowired
    ImageService imageService ;
    
    @Autowired 
    UserService userservice;
    
    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
    @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id) ;
    }
    @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return imageService.getImage(id);
    }
    
    @RequestMapping(value = "/loadImageUser/{name}" , method = RequestMethod.GET)
    public Image getImageByName(@PathVariable("name") String name) throws IOException {
    	User user=userservice.findUserByUsername(name);
        return imageService.getImageDetails(user.getImage().getIdImage());
    }
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id){
        imageService.deleteImage(id);
    }
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
}