package com.soft.provider.api;

import com.soft.provider.entity.Plant;
import com.soft.provider.response.AjaxResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrongqi
 */

@RestController
@RequestMapping("/api")
public class ProviderController {

    @GetMapping("hello")
    public String getHello() {
        return "hello world";
    }

    @GetMapping("plant")
    public AjaxResponse getPlant() {
        List<Plant> plantList = new ArrayList<>();
        plantList.add(new Plant("向日葵","信念、光辉、高傲、忠诚、爱慕",18.0,2));
        plantList.add(new Plant("玫瑰","纯洁的爱、美丽的爱情、美好常在",8.0,20));
        plantList.add(new Plant("满天星","清纯、关怀、思恋、配角、真爱以及纯洁的心灵、思念、清纯、梦境、真心喜欢，甘做配角的爱",1.0,50));
        return AjaxResponse.success(plantList);
    }
}
