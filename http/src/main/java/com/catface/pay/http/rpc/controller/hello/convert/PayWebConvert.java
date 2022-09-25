package com.catface.pay.http.rpc.controller.hello.convert;

import com.catface.pay.api.order.request.CreatePayOrderRequest;
import com.catface.pay.repository.entity.PayOrder;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author by catface
 * @date 2021/7/29 8:57 下午
 */
public class PayWebConvert {

  private static final BeanCopier REQUEST_2_ENTITY = BeanCopier.create(CreatePayOrderRequest.class,
      PayOrder.class, false);

  public static PayOrder convert(CreatePayOrderRequest request) {
    PayOrder entity = new PayOrder();
    REQUEST_2_ENTITY.copy(request, entity, null);
    return entity;
  }
}
