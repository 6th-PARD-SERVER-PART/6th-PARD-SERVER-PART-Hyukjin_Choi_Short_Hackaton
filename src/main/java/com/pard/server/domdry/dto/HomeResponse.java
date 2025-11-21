package com.pard.server.domdry.dto;

import com.pard.server.domdry.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeResponse {

    private List<OrderSummary> orders;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderSummary{
        private Long orderId;
        private LocalDateTime pickUpDateTime;
        private String placeName;
        private OrderStatus status;
        private Integer price;
    }
}
