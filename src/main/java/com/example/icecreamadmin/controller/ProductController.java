package com.example.icecreamadmin.controller;

import com.example.icecreamadmin.model.ProductEntity;
import com.example.icecreamadmin.services.FirebaseServiceProduct;
import com.example.icecreamadmin.services.modul.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.icecreamadmin.services.CloudinaryService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Controller
public class ProductController {

    private final FirebaseServiceProduct productFirebase = new FirebaseServiceProduct("news");

    @GetMapping("/adminka_ice_cream")
    public String getAdminkaIceCream(Model model) {
        ThymleafUIModulProduct thymleafUIModul = new ThymleafUIModulProduct(model);
        thymleafUIModul.showData(productFirebase);
        return "adminka_ice_cream";
    }

    @PostMapping("/adminka_ice_cream")
    public String postAdminkaIceCream(
            @RequestParam("title") String title,
            @RequestParam("short-info") String shortInfo,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("currency") String currency,
            @RequestParam(value = "old-price", required = false) Double oldPrice,
            @RequestParam("sku") String sku,
            @RequestParam(value = "out-of-stock", defaultValue = "false") Boolean outOfStock,
            @RequestParam(value = "featured", defaultValue = "false") Boolean featured,
            @RequestParam("categories") String categories,
            @RequestParam("image") MultipartFile imageUrl,
            Model model) throws IOException {

        CloudinaryService cloudinaryService = new CloudinaryService();
        List<String> imageLinks = new ArrayList<>();

        for (MultipartFile image : images) {
            String imageLink = cloudinaryService.uploadCloudinary(FileService.convertMultipartFileToFile(image));
            imageLinks.add(imageLink);
        }

        ProductEntity productEntity = new ProductEntity(
    public ProductEntity(title, shortInfo, description, price, currency,  oldPrice,  sku,  outOfStock, featured,  categories,  imageUrl);
        System.out.println(type);

        if (type.equals("none")) {
            productFirebase.saveProduct(productEntity);
        } else {
            productFirebase.updateByKey(type, productEntity);
        }

        ThymleafUIModulProduct thymleafUIModul = new ThymleafUIModulProduct(model);
        thymleafUIModul.showData(productFirebase);

        return "redirect:/adminka_ice_cream";
    }

    @PostMapping("/updateProduct")
    public String updateIceCream(@RequestParam("update_key") String update_key, Model model) {
        ThymleafUIModulProduct thymleafUIModul = new ThymleafUIModulProduct(model);
        thymleafUIModul.updateShow(productFirebase, update_key);
        return "adminka_ice_cream";
    }

    @PostMapping("/deleteProduct")
    public String deleteIceCream(@RequestParam("delete_key") String delete_key) {
        productFirebase.deleteByKey(delete_key);
        return "redirect:/adminka_ice_cream";
    }
}











//package com.example.icecreamadmin.controller;
//
//import com.example.icecreamadmin.model.ProductEntity;
//import com.example.icecreamadmin.services.CloudinaryService;
//import com.example.icecreamadmin.services.FirebaseServiceProduct;
//import com.example.icecreamadmin.services.modul.FileService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping
//@Controller
//public class ProductController {
//
//    private final FirebaseServiceProduct productFirebase = new FirebaseServiceProduct("sdfs");
//
//    // Показать форму добавления продукта
//    @GetMapping("/adminka_ice_cream")
//    public String showAddProductForm(Model model) {
//        return "adminka_ice_cream"; // Возвращаем HTML-страницу с формой добавления продукта
//    }
//
//    // Обработать отправку формы добавления продукта
//    @PostMapping("/adminka_ice_cream")
//    public String addProduct(
//            @RequestParam("title") String title,
//            @RequestParam("short-info") String shortInfo,
//            @RequestParam("description") String description,
//            @RequestParam("price") Double price,
//            @RequestParam("currency") String currency,
//            @RequestParam(value = "old-price", required = false) Double oldPrice,
//            @RequestParam("sku") String sku,
//            @RequestParam(value = "out-of-stock", defaultValue = "false") Boolean outOfStock,
//            @RequestParam(value = "featured", defaultValue = "false") Boolean featured,
//            @RequestParam("categories") String categories,
//            @RequestParam("image") MultipartFile imageUrl,
//            Model model) throws IOException {
//
//        // Сервис для загрузки изображения в Cloudinary
//        CloudinaryService cloudinaryService = new CloudinaryService();
//
//        // Загружаем изображение на Cloudinary и получаем ссылку
//        String imageLink = cloudinaryService.uploadCloudinary(FileService.convertMultipartFileToFile(imageUrl));
//
//        // Создаем объект ProductEntity с данными из формы
//        ProductEntity productEntity = new ProductEntity(
//                title,
//                shortInfo,
//                description,
//                price,
//                currency,
//                oldPrice,
//                sku,
//                outOfStock,
//                featured,
//                categories,
//                imageLink
//        );
//
//        // Сохраняем продукт в Firebase
//        productFirebase.saveProduct( title,
//                shortInfo,
//                description,
//                price,
//                currency,
//                oldPrice,
//                sku,
//                outOfStock,
//                featured,
//                categories, imageLink);
//
//        // Добавляем сообщение об успешном добавлении продукта
//        model.addAttribute("message", "Продукт успешно добавлен!");
//
//        return "redirect:/adminka_ice_cream"; // Перенаправляем на страницу добавления продукта
//    }
//}
