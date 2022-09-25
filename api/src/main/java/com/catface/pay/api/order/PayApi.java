package com.catface.pay.api.order;

import com.catface.common.model.JsonResult;
import com.catface.pay.api.order.request.CreatePayOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author by catface
 * @date 2020/12/15
 */

@FeignClient(name = "payApi", url = "${rpc.pay.service}", fallbackFactory = PayApiFallback.class)
public interface PayApi {

  /**
   * 打招呼接口
   *
   * @param request 打招呼请求参数
   * @return 打招呼回应
   */
  @PostMapping(value = {"/private/pay/createPayOrder"})
  JsonResult<Boolean> createPayOrder(CreatePayOrderRequest request);

}
