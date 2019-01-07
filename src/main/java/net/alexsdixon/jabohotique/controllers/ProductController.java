package net.alexsdixon.jabohotique.controllers;


import net.alexsdixon.jabohotique.models.data.ProductDao;
import net.alexsdixon.jabohotique.models.forms.Product;
import net.alexsdixon.jabohotique.models.forms.ProductCategory;
import net.alexsdixon.jabohotique.models.forms.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title", "PRODUCTS");
        return "admin/product/index";
    }


    @RequestMapping(value= "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model){

        model.addAttribute("title", "ADD PRODUCT");
        model.addAttribute (new Product());
        model.addAttribute("productCategories",ProductCategory.values());
        model.addAttribute("productTypes",ProductType.values());
        return "admin/product/add";
    }

    @RequestMapping (value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute @Valid Product newProduct, Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "ADD PRODUCT");
            model.addAttribute("productCategories", ProductCategory.values());
            model.addAttribute("productTypes", ProductType.values());
            return "admin/product/add";
        }

        productDao.save(newProduct);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {
        model.addAttribute("products", productDao.findAll());
        model.addAttribute ("title", "DELETE PRODUCT");
        return "admin/product/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@RequestParam(required=false) int[] productIds, Model model) {

        if (productIds == null) {
            model.addAttribute("products", productDao.findAll());
            model.addAttribute ("title", "DELETE PRODUCT");
            model.addAttribute ("message", "Please choose an Product to delete or go back");
            return "admin/product/remove";
        }

        for (int productId : productIds) {
            productDao.delete(productId);
        }

        return "redirect:";
    }


    @RequestMapping(value = "edit/{productId}", method = RequestMethod.GET)
    public String displayEditProductForm(Model model, @PathVariable int productId) {

        model.addAttribute("title", "EDIT PRODUCT");
        model.addAttribute("product", productDao.findOne(productId));
        return "admin/product/edit";
    }

    @RequestMapping(value = "edit/{productId}", method = RequestMethod.POST)
    public String processEditProductForm(Model model, @PathVariable int productId,
                                        @ModelAttribute  @Valid Product newProduct, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "EDIT PRODUCT");
            return "admin/product/edit";
        }

        Product editedProduct = productDao.findOne(productId);
        editedProduct.setProduct_name(newProduct.getProduct_name());
        editedProduct.setCategory(newProduct.getCategory());
        editedProduct.setType(newProduct.getType());
        editedProduct.setSize(newProduct.getSize());
        editedProduct.setPrice(newProduct.getPrice());
        editedProduct.setFirst_image(newProduct.getFirst_image());
        editedProduct.setSecond_image(newProduct.getSecond_image());
        productDao.save(editedProduct);

        return "redirect:admin/product";
    }



}
