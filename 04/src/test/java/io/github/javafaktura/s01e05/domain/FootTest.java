package io.github.javafaktura.s01e05.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FootTest {

    @ParameterizedTest(name = "Given {0} foot should be converted to {1} meters")
    @CsvSource( {
            " 0.00,       0.00",
            " 0.33,       0.10",
            " 1.00,       0.30",
            "10.23,       3.12"
    })
    void givenFootShouldBeConvertedToFollowingMetersValue(
            double foot, double expectedMeters
    ) {
        Assertions.assertEquals(expectedMeters, Foot.of(foot).toMeter().getValue());
    }
}
