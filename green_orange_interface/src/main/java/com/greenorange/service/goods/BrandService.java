package com.greenorange.service.goods;

import com.greenorange.pojo.entity.PageResult;
import com.greenorange.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<Brand> findAll();

    public PageResult<Brand> findPage(int page, int size);

    public List<Brand> findList(Map<String, Object> searchMap);

    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size);
}
