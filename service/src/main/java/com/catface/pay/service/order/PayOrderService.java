package com.catface.pay.service.order;

import com.catface.pay.repository.entity.PayOrder;

/**
 * @author catface
 * @since 2022/9/25
 */
public interface PayOrderService {

  /**
   * 创建支付单
   * @param entity 待保存的支付单
   */
  void createPayOrder(PayOrder entity);
}
