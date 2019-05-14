package io.github.javafaktura.s01e05.anemic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WaveHeightToBeaufortScaleConverterTest {

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
        Assertions.assertEquals(expectedMeters, WaveHeightToBeaufortScaleConverter.footToMeters(foot));
    }

    @ParameterizedTest(name = "Given wave of height {0} ft. should be following Beaufort scale = {1}")
    @CsvSource( {
            "0,     0",
            "0.33,  1",
            "0.66,  2",
            "2   ,  3",
            "3.3,   4",
            "6.6,   5",
            "9.9,   6",
            "13.1,  7",
            "18,    8",
            "23,    9",
            "29.5, 10",
            "37.7 ,11",
            "46,   12",
            "100,  12",
    })
    void givenWaveHeightInFootShouldBeFollowingBeaufortScale(
            double foot, int expectedBeaufort
    ) {
        Assertions.assertEquals(expectedBeaufort, WaveHeightToBeaufortScaleConverter.convertFoot(foot).getScale());
    }

    @ParameterizedTest(name = "Given wave of height {0} meters should be following Beaufort scale = {1}")
    @CsvSource( {
            " 0,     0",
            " 0.1,   1",
            " 0.19,  1",
            " 0.2,   2",
            " 0.59,  2",
            " 0.99,  3",
            " 1.99,  4",
            " 2.99,  5",
            " 3.5,   6",
            " 4,     7",
            " 5.5,   8",
            " 6.99,  8",
            " 7.5,   9",
            " 9,    10",
            "11.5,  11",
            "13.99, 11",
            "30,    12"
    })
    void givenWaveHeightInMetersShouldBeFollowingBeaufortScale(
            double meters, int expectedBeaufort
    ) {
        Assertions.assertEquals(expectedBeaufort, WaveHeightToBeaufortScaleConverter.convertMeters(meters).getScale());
    }

    @ParameterizedTest(name = "Given wave of height {0} {1}S should be following Beaufort scale = {2}")
    @CsvSource( {
            "0,     FOOT,   0",
            "0.33,  FOOT,   1",
            "0.65,  FOOT,   1",
            "1.99,  FOOT,   2",
            "2   ,  FOOT,   3",
            "3.3,   FOOT,   4",
            "6.6,   FOOT,   5",
            "9.9,   FOOT,   6",
            "13.1,  FOOT,   7",
            "18,    FOOT,   8",
            "23,    FOOT,   9",
            "29.5,  FOOT,  10",
            "37.7 , FOOT,  11",
            "46,    FOOT,  12",
            "100,   FOOT,  12",
            " 0,    METER,  0",
            " 0.09, METER,  0",
            " 0.1,  METER,  1",
            " 0.19, METER,  1",
            " 0.2,  METER,  2",
            " 0.59, METER,  2",
            " 0.99, METER,  3",
            " 1.99, METER,  4",
            " 2.99, METER,  5",
            " 3.5,  METER,  6",
            " 4,    METER,  7",
            " 5.5,  METER,  8",
            " 6.99, METER,  8",
            " 7.5,  METER,  9",
            " 9,    METER, 10",
            "11.5,  METER, 11",
            "13.99, METER, 11",
            "30,    METER, 12"
    })
    void givenWaveHeightShouldBeFollowingBeaufortScale(
            double foot, HeightUnit unit, int expectedBeaufort
    ) {
        Assertions.assertEquals(expectedBeaufort, WaveHeightToBeaufortScaleConverter.convert(foot, unit).getScale());
    }
}
