package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public enum Item {

    //(String name, String productReference, String condition, String description, ArrayList imgsources,
    //         String mainImage, Double price, Double discount, String composition, String styles, String properties,
    //         String moreInfo,String reviews, ArrayList sizes)
    FADED_SHORT_SLEEVE_(
            "Printed Chiffon Dress",
            "Model demo_7",
            "New",
            "Printed chiffon knee length dress with tank straps. Deep v-neckline.",
            new String[]{"http://automationpractice.com/img/p/2/0/20-cart_default.jpg", "http://automationpractice.com/img/p/2/1/21-cart_default.jpg"},
            "http://automationpractice.com/img/p/2/0/20-cart_default.jpg",
            20.50,
            4.10,
            "Polyester",
            "Girly",
            "Midi Dress",
            "Fashion has been creating well-designed collections since 2010. The brand offers feminine designs " +
                    "delivering stylish separates and statement dresses which has since evolved into a full ready-to-wear collection in which " +
                    "every item is a vital part of a woman's wardrobe. The result? Cool, easy, chic looks with youthful elegance and unmistakable" +
                    "signature style. All the beautiful pieces are made in Italy and manufactured with the greatest attention. Now Fashion extends to a " +
                    "range of accessories including shoes, hats, belts and more!",
            "No customer comments for the moment.",
            new Character[]{'s','m','l'},
            new String[]{"Green","Yellow"},
            7
    );

    final String NAME,
            ProductReference,
            Condition,
            Description,
            MainImage,
            Composition,
            Styles,
            Properties,
            MoreInfo,
            Reviews,
            ADD_PREFIX = "data-id-product=",
            REMOVE_PREFIX = "remove-";
    int ID;
    final double Price;
    double Discount=0;
    String[] ImgSources;
    String[] Colours;
    final Character[] Sizes;

    final By
            BY_ADD,
            BY_REMOVE;
    Item(String name, String productReference, String condition, String description, String[] imgsources,
         String mainImage, Double price, Double discount, String composition, String styles, String properties,
         String moreInfo, String reviews, Character[] sizes, String[] colours, int id) {
        NAME=name;
        ProductReference=productReference;
        Condition= condition;
        Description=description;
        ImgSources= imgsources;
        MainImage= mainImage;
        Price=price;
        Discount= discount;
        Composition=composition;
        Styles=styles;
        Properties=properties;
        Reviews=reviews;
        Sizes=sizes;
        MoreInfo=moreInfo;
        Colours=colours;
        ID=id;
        BY_ADD = new By.ById((ADD_PREFIX + ID));
        BY_REMOVE = new By.ById((REMOVE_PREFIX + ID));
    }
}
