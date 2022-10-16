package de.duke2k.gpxviewer.util;

import de.duke2k.gpxviewer.xjc.WptType;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.OptionalDouble;

import static java.lang.Math.PI;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class GpxUtils {

  private GpxUtils() {
    // Utility class
  }

  @Nonnegative
  public static double getDistance(double lat1, double lon1, double lat2, double lon2) {
    double earthRadius = 6371000.785;
    double dLat = deg2rad(lat2 - lat1);
    double dLon = deg2rad(lon2 - lon1);
    double a = sin(dLat / 2) * sin(dLat / 2) + cos(deg2rad(lat1)) * cos(deg2rad(lat2)) * sin(dLon / 2) * sin(dLon / 2);
    double c = 2 * atan2(sqrt(a), sqrt(1 - a));
    return earthRadius * c;
  }

  @Nonnull
  public static Pair<BigDecimal, BigDecimal> findCentre(@Nonnull Collection<WptType> waypoints) {
    double sumOfLats = waypoints.stream()
        .map(WptType::getLat)
        .mapToDouble(BigDecimal::doubleValue)
        .sum();
    double sumOfLons = waypoints.stream()
        .map(WptType::getLon)
        .mapToDouble(BigDecimal::doubleValue)
        .sum();
    return Pair.of(BigDecimal.valueOf(sumOfLats / waypoints.size()), BigDecimal.valueOf(sumOfLons / waypoints.size()));
  }

  @Nonnull
  public static BigDecimal findIdealZoomFactor(@Nonnull Collection<WptType> waypoints) {
    double scaleLat = 0;
    OptionalDouble maxOfLats = waypoints.stream()
        .map(WptType::getLat)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::max);
    OptionalDouble minOfLats = waypoints.stream()
        .map(WptType::getLat)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::min);
    if (maxOfLats.isPresent() && minOfLats.isPresent()) {
      scaleLat = 180.0 / (maxOfLats.getAsDouble() - minOfLats.getAsDouble());
    }
    double scaleLon = 0;
    OptionalDouble maxOfLons = waypoints.stream()
        .map(WptType::getLon)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::max);
    OptionalDouble minOfLons = waypoints.stream()
        .map(WptType::getLon)
        .mapToDouble(BigDecimal::doubleValue)
        .reduce(Double::min);
    if (maxOfLons.isPresent() && minOfLons.isPresent()) {
      scaleLon = 180 / maxOfLons.getAsDouble() - minOfLons.getAsDouble();
    }
    return BigDecimal.valueOf(Math.log((scaleLat + scaleLon) / 2) / Math.log(2));
  }

  private static double deg2rad(double deg) {
    return deg * (PI / 180);
  }
}
