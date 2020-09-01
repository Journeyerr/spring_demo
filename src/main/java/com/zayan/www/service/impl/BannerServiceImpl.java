package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.constant.common.aliyun.ALiYunOss;
import com.zayan.www.model.entity.Banner;
import com.zayan.www.model.vo.admin.BannerVO;
import com.zayan.www.repository.BannerMapper;
import com.zayan.www.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-01
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Override
    public IPage<BannerVO> listRecord(Integer shopId, Integer status, Integer page, Integer pageSize) {

        IPage<BannerVO> bannerVOIPage = this.baseMapper.bannerList(shopId, status, new Page(page, pageSize));
        List<BannerVO> listVo = bannerVOIPage.getRecords();
        if (CollectionUtils.isEmpty(listVo)) {
            return bannerVOIPage;
        }
        listVo.forEach( v -> v.setBannerImage(ALiYunOss.BUCKET + v.getBannerImage()));
        return bannerVOIPage;
    }
}
