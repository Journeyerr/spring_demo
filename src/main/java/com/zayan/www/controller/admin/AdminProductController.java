package com.zayan.www.controller.admin;


import com.zayan.www.model.entity.Product;
import com.zayan.www.model.form.admin.product.ProductCreateForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.api.product.ProductVO;
import com.zayan.www.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@RestController
@RequestMapping("admin/product/image")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("创建商品")
    @PostMapping("/store")
    public BaseResult<ProductVO> store(@RequestBody ProductCreateForm createForm){
        Product product = productService.saveProduct(createForm);

        ProductVO productVO = new ProductVO();
        productVO.setPrice(product.getPrice());
        productVO.setName(product.getName());
        productVO.setRemark(product.getRemark());
        productVO.setImageId(product.getImageId());

        return BaseResult.success(productVO);
    }
}

