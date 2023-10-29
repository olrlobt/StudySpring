package com.ssafy.example.product.model.service.mapper;


import com.ssafy.example.product.dto.ProductDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {


    List<ProductDto> getList();


}
