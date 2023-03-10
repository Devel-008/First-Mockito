package com.mocked.construction.payment;

import org.mockito.MockedConstruction;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class CheckoutServiceTest {

    @Test
    void mockObjectConstruction() {
        try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class,
                (mock, context) -> {
                    // further stubbings ...
                    when(mock.chargeCustomer(anyString(), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
                })) {

            CheckoutService cut = new CheckoutService();

            BigDecimal result = cut.purchaseProduct("MacBook Pro", "42");

            assertEquals(BigDecimal.TEN, result);
        }
    }
}
