package cn.waynechu.renting.facade.request;

import lombok.Data;

/**
 * @author zhuwei
 * @date 2018/12/29 12:46
 */
@Data
public class HouseSearchReq {
    private String title;

    private Integer price;

    private Integer area;

    private Integer room;

    private Integer floor;

    private Integer totalFloor;

    private Integer watchTimes;

    private Integer buildYear;

    private Integer status;

    private String cityEnName;

    private String regionEnName;

    private String cover;

    private Integer direction;

    private Integer distanceToSubway;

    private Integer parlour;

    private String district;

    private Long adminId;

    private Integer bathroom;

    private String street;
}
