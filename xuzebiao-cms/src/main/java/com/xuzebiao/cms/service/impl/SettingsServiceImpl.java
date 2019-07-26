package com.xuzebiao.cms.service.impl;

import com.xuzebiao.cms.domain.Settings;
import com.xuzebiao.cms.dao.SettingsMapper;
import com.xuzebiao.cms.service.ISettingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@Service
public class SettingsServiceImpl extends ServiceImpl<SettingsMapper, Settings> implements ISettingsService {

}
