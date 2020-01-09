package com.waynechu.order.domain.service;

import cn.waynechu.facade.common.enums.BizErrorCodeEnum;
import cn.waynechu.facade.common.exception.BizException;
import cn.waynechu.springcloud.common.util.BeanUtil;
import com.waynechu.order.dal.dataobject.order.OrderDO;
import com.waynechu.order.domain.convert.OrderConvert;
import com.waynechu.order.domain.repository.OrderRepository;
import com.waynechu.order.facade.response.OrderDetailResponse;
import com.waynechu.order.facade.response.OrderResponse;
import com.waynechu.order.remote.model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuwei
 * @date 2019/9/19 18:13
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    /**
     * 根据订单id获取订单信息
     *
     * @param orderId 订单id
     * @return 订单信息
     */
    public OrderResponse getById(Long orderId) {
        OrderDO order = orderRepository.getById(orderId);
        return OrderConvert.toOrderResponse(order);
    }

    /**
     * 根据订单id获取订单详情
     *
     * @param orderId 订单id
     * @return 订单详情
     */
    public OrderDetailResponse getDetailById(Long orderId) {
        // 状态判断、时效性要求高的查询优先走主库，防止主从同步延迟导致读取脏数据
        OrderDO order = orderRepository.getByIdFromMaster(orderId);
        if (order == null) {
            throw new BizException(BizErrorCodeEnum.DATA_NOT_EXIST);
        }

        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        BeanUtil.copyProperties(order, orderDetailResponse);

        ProductResponse product = productService.getById(order.getProductId());
        if (product != null) {
            BeanUtil.copyProperties(product, orderDetailResponse);
        }
        return orderDetailResponse;
    }
}
