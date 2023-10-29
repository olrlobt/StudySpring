package com.ssafy.example.product.model.service;


import com.ssafy.example.product.dto.ProductDto;
import com.ssafy.example.product.model.service.mapper.ProductMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    public List<ProductDto> getList() {
        return productMapper.getList();
    }
}
