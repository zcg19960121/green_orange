package com.greenorange.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.greenorange.pojo.entity.PageResult;
import com.greenorange.pojo.goods.Brand;
import com.greenorange.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page, int size) {

        return brandService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map searchMap) {
        return brandService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult findList(@RequestBody Map searchMap, int page, int size) {
        return brandService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public Brand findById(int id) {
        return brandService.findById(id);
    }


}
