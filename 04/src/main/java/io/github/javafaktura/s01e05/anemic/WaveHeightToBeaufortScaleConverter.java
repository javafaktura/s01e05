package io.github.javafaktura.s01e05.anemic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WaveHeightToBeaufortScaleConverter {
    public static BeaufortScale convert(double waveHeight, HeightUnit unit) {
        switch (unit) {
            case METER:
                return convertMeters(waveHeight);
            case FOOT:
                return convertFoot(waveHeight);
        }
        throw new IllegalArgumentException("Missing unit parameter to properly convert waveHeight to beaufort scale");
    }

    /** Was supposed to be private but I need to test it, so make it public **/
    public static BeaufortScale convertFoot(double waveHeight) {
        if (waveHeight >= 46) {
            return BeaufortScale.HURRICANE;
        } else if (waveHeight >= 37.7) {
            return BeaufortScale.VIOLENT_STORM;
        } else if (waveHeight >= 29.5) {
            return BeaufortScale.STORM;
        } else if (waveHeight >= 23) {
            return BeaufortScale.STRONG_GALE;
        } else if (waveHeight >= 18) {
            return BeaufortScale.GALE;
        } else if (waveHeight >= 13.1) {
            return BeaufortScale.HIGH_WIND;
        } else if (waveHeight >= 9.9) {
            return BeaufortScale.STRONG_BREEZE;
        } else if (waveHeight >= 6.6) {
            return BeaufortScale.FRESH_BREEZE;
        } else if (waveHeight >= 3.3) {
            return BeaufortScale.MODERATE_BREEZE;
        } else if (waveHeight >= 2) {
            return BeaufortScale.GENTLE_BREEZE;
        } else if (waveHeight >= 0.66) {
            return BeaufortScale.LIGHT_BREEZE;
        } else if (waveHeight >= 0.33) {
            return BeaufortScale.LIGHT_AIR;
        } else {
            return BeaufortScale.CALM;
        }
    }

    /** Was supposed to be private but I need to test it, so make it public **/
    public static BeaufortScale convertMeters(double waveHeight) {
        double foot = metersToFoot(waveHeight);
        return convertFoot(foot);
    }

    /** Was supposed to be private but I need to test it, so make it public **/
    public static double footToMeters(double foot) {
        return BigDecimal.valueOf(foot)
                .multiply(
                        BigDecimal.valueOf(0.3048)
                ).setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /** Was supposed to be private but I need to test it, so make it public **/
    public static double metersToFoot(double meters) {
        return BigDecimal.valueOf(meters)
                .divide(
                        BigDecimal.valueOf(0.3048),
                        4,
                        RoundingMode.HALF_UP
                ).setScale(2, RoundingMode.UP)
                .doubleValue();
    }
}
