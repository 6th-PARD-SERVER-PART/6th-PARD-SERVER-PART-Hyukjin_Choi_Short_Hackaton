package com.pard.server.domdry.service;

import com.pard.server.domdry.domain.Order;
import com.pard.server.domdry.domain.PickUpPlace;
import com.pard.server.domdry.domain.PickUpSchedule;
import com.pard.server.domdry.domain.PickUpSchedulePlace;
import com.pard.server.domdry.dto.HomeResponse;
import com.pard.server.domdry.repository.OrderRepository;
import com.pard.server.domdry.repository.PickUpPlaceRepository;
import com.pard.server.domdry.repository.PickUpSchedulePlaceRepository;
import com.pard.server.domdry.repository.PickUpScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final OrderRepository orderRepository;
    private final PickUpScheduleRepository pickUpScheduleRepository;
    private final PickUpPlaceRepository pickUpPlaceRepository;
    private final PickUpSchedulePlaceRepository pickUpSchedulePlaceRepository;

    public HomeResponse getOrdersForHome(Long memberId) {

        // 1) 멤버의 모든 주문 조회
        List<Order> orders = orderRepository.findByMemberId(memberId);

        // 2) 주문 요약 정보로 변환
        List<HomeResponse.OrderSummary> orderSummaries = orders.stream()
                .map(order -> {

                    // pickUpSchedulePlace 조회
                    PickUpSchedulePlace ssp = pickUpSchedulePlaceRepository
                            .findById(order.getPickupSchedulePlaceId())
                            .orElseThrow();

                    // schedule 조회
                    PickUpSchedule schedule = pickUpScheduleRepository
                            .findById(ssp.getPickUpScheduleId())
                            .orElseThrow();

                    // place 조회
                    PickUpPlace place = pickUpPlaceRepository
                            .findById(ssp.getPickUpPlaceId())
                            .orElseThrow();

                    return HomeResponse.OrderSummary.builder()
                            .orderId(order.getId())
                            .pickUpDateTime(schedule.getPickUpTime())
                            .placeName(place.getName())
                            .status(order.getStatus())
                            .price(20000)   // MVP: 고정가격
                            .build();
                })
                .toList();

        return HomeResponse.builder()
                .orders(orderSummaries)
                .build();
    }
}