package cn.waynechu.utility.facade.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author zhuwei
 * @since 2020/4/9 10:09
 */
@Data
@ApiModel
public class CandlerResponse {

    @ApiModelProperty("月初第一天是周几。可选值1-7(代表周一到周日)")
    private Integer firstDayOfWeek;

    @ApiModelProperty("每天日历信息")
    private List<CandlerItemResponse> dayDates;
}
