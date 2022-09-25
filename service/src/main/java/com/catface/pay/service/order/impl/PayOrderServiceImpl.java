package com.catface.pay.service.order.impl;

import com.catface.common.exception.CatfaceException;
import com.catface.pay.repository.entity.PayOrder;
import com.catface.pay.repository.service.PayOrderRpService;
import com.catface.pay.service.order.PayOrderService;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author catface
 * @since 2022/9/25
 */
@Slf4j
@Service
public class PayOrderServiceImpl implements PayOrderService {

  private final PayOrderRpService payOrderRpService;

  public PayOrderServiceImpl(PayOrderRpService payOrderRpService) {
    this.payOrderRpService = payOrderRpService;
  }

  /**
   * 创建支付单
   *
   * @param entity 待保存的支付单
   */
  @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  @Override
  public void createPayOrder(PayOrder entity) {
    // 保存支付单
    payOrderRpService.save(entity);

    // 支付金额为2,或者为3时,通过异常对保存的支付单进行回滚
    if (entity.getPayAmount().equals(new BigDecimal("2"))) {
      throw new CatfaceException("invalid_trade_amount", "指定金额故意失败回滚");
    }
    if (entity.getPayAmount().equals(new BigDecimal("3"))) {
      throw new CatfaceException("invalid_trade_amount", "指定金额故意失败回滚");
    }

  }
}
