package com.greenorange.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.greenorange.dao.BrandMapper;
import com.greenorange.pojo.entity.PageResult;
import com.greenorange.pojo.goods.Brand;
import com.greenorange.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageResult<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectAll();
        return new PageResult<Brand>(pageResult.getTotal(), pageResult.getResult());
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = this.createExample(searchMap);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = this.createExample(searchMap);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<Brand>(pageResult.getTotal(), pageResult.getResult());
    }

    @Override
    public Brand findById(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        //设置name模糊查询
        if (searchMap != null) {
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");
            }
        }
        //设置首字母匹配查询
        if (searchMap != null) {
            if (searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))) {
                criteria.andEqualTo("letter", (String) searchMap.get("letter"));
            }
        }

        return example;
    }

}
