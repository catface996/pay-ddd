package com.catface.pay.api.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author by catface
 * @date 2020/12/15
 */
@ApiModel(description = "打招呼请求")
@Data
public class CreatePayOrderRequest {

  @ApiModelProperty(value = "支付单ID", required = true, example = "1212121212")
  @NotNull(message = "支付单ID不能为空")
  private Long id;

  @ApiModelProperty(value = "交易订单ID", required = true, example = "222222222")
  @NotNull(message = "交易订单ID不能为空")
  private Long tradeOrderId;

  @ApiModelProperty(value = "交易金额", required = true, example = "3.00")
  @NotNull(message = "交易金额不能为空")
  private BigDecimal payAmount;


}
