package com.fastcampus.bookmanager.domain;

import lombok.Data;

@Data
public class Manufacturer {
    private int code;

    private String description;


    public Manufacturer(int code){
        this.code =code;
        this.description = addDescription(code);
    }

    private String addDescription(int code){

        switch (code){
            case 200 :
                return "Apple";

            case 300 :
                return "Saumsung";

            case 400 :
                return "BlackBerry";

            default  :
                return "기타회사" ;
        }



    }


}
