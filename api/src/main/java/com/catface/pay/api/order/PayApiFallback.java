package com.catface.pay.api.order;

import com.catface.common.model.JsonResult;
import com.catface.pay.api.order.request.CreatePayOrderRequest;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author by catface
 * @date 2020/12/15
 */
@Slf4j
@Component
public class PayApiFallback implements FallbackFactory<PayApi> {

  @Override
  public PayApi create(Throwable throwable) {
    return new PayApi() {


      /**
       * 打招呼接口
       *
       * @param request 打招呼请求参数
       * @return 打招呼回应
       */
      @Override
      public JsonResult<Boolean> createPayOrder(CreatePayOrderRequest request) {
        log.error("远程调用支付系统创建支付单异常,request:{}", request);
        return JsonResult.rpcError("远程调用支付系统创建支付单异常");
      }
    };
  }
}
