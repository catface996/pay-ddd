package com.catface.pay.repository.service.impl;

import com.catface.pay.repository.entity.PayOrder;
import com.catface.pay.repository.mapper.PayOrderMapper;
import com.catface.pay.repository.service.PayOrderRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付单 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-09-25
 */
@Service
public class PayOrderRpServiceImpl extends ServiceImpl<PayOrderMapper, PayOrder> implements PayOrderRpService {

}
