package org.iclass.spring_4restapi.service;

import java.util.List;

import org.iclass.spring_4restapi.dto.ProductDto;
import org.iclass.spring_4restapi.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class ProductService {
    private ProductMapper mapper;

    public List<ProductDto> keywordProduct(String keyword) {
        return mapper.selectByKeyword(keyword);
    }

    public ProductDto getProduct(String pcode) {
        return mapper.selectByPk(pcode);
    }

    public List<ProductDto> allProduct() {
        return mapper.selectAll();
    }

    public int join(ProductDto dto) {
        return mapper.insert(dto);
    }

    public int changeInfo(ProductDto dto) {
        return mapper.update(dto);
    }

    public int removeProduct(String pcode) {
        return mapper.delete(pcode);
    }
}
