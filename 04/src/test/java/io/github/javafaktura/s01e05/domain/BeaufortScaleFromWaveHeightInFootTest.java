package io.github.javafaktura.s01e05.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class BeaufortScaleFromWaveHeightInFootTest {

    @ParameterizedTest(name = "Given wave of height {0} in foot should be following Beaufort scale = {1}")
    @CsvSource( {
            "0,       0",
            "0.32,    0",
            "0.33,    1",
            "0.65,    1",
            "0.66,    2",
            "1.99,    2",
            "2   ,    3",
            "3.29,    3",
            "3.3,     4",
            "6.59,    4",
            "6.6,     5",
            "9.89 ,   5",
            "9.9,     6",
            "13.09,   6",
            "13.1,    7",
            "17.99,   7",
            "18,      8",
            "22.99,   8",
            "23,      9",
            "29.49,   9",
            "29.5,    10",
            "37.69,   10",
            "37.7 ,   11",
            "45.99,   11",
            "46,      12",
            "100,     12",
    })
    void shouldReturnFollowingBeaufortScale(
            double waveHeight, int expectedScale
    ) {
        Assertions.assertEquals(expectedScale, BeaufortScale.from(Foot.of(waveHeight)).getScale());
    }
}
