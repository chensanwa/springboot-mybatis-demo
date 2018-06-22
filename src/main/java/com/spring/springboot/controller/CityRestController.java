package com.spring.springboot.controller;

import com.spring.springboot.domain.City;
import com.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/6/22
 * Time: 15:34
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    /** 整合测试接口 */
//    @GetMapping(value = "/api/city")
//    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
//        return cityService.findCityByName(cityName);
//    }

    /** Rest风格 */
    @GetMapping(value = "/api/city")
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @GetMapping(value = "/api/city/{id}")
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @PostMapping(value = "/api/city")
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @PutMapping(value = "/api/city")
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }

}
