package com.catface.pay.http.rpc.controller.hello;

import com.catface.common.model.JsonResult;
import com.catface.pay.api.order.PayApi;
import com.catface.pay.api.order.request.CreatePayOrderRequest;
import com.catface.pay.http.config.swagger.SwaggerTagConst;
import com.catface.pay.http.rpc.controller.hello.convert.PayWebConvert;
import com.catface.pay.repository.entity.PayOrder;
import com.catface.pay.service.order.PayOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by catface
 * @date 2020/12/15
 */
@Api(tags = {SwaggerTagConst.PAY_ORDER})
@RestController
public class PayApiController implements PayApi {

  private final PayOrderService payOrderService;

  public PayApiController(PayOrderService payOrderService) {
    this.payOrderService = payOrderService;
  }

  /**
   * 打招呼接口
   *
   * @param request 打招呼请求参数
   * @return 打招呼回应
   */
  @ApiOperation(value = "创建支付单")
  @Override
  public JsonResult<Boolean> createPayOrder(@RequestBody @Valid CreatePayOrderRequest request) {
    PayOrder entity = PayWebConvert.convert(request);
    payOrderService.createPayOrder(entity);
    return JsonResult.success(true);
  }
}
