package io.github.javafaktura.s01e05.domain;

import io.github.javafaktura.s01e05.anemic.WaveHeightToBeaufortScaleConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MeterTest {

    @ParameterizedTest(name = "Given {0} meters should be converted to {1} foot")
    @CsvSource( {
            "0.00,  0.00",
            "0.10,  0.33",
            "0.30,  0.98",
            "3.12, 10.24"
    })
    void givenMetersShouldBeConvertedToFollowingFootValue(
            double meters, double expectedFoot
    ) {
        Assertions.assertEquals(expectedFoot, Meter.of(meters).toFoot().getValue());
    }
}
