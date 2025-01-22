package com.thealgorithms.geometry;

import java.awt.Point;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * The {@code BresenhamLineTest} class contains unit tests for the
 * {@code BresenhamLine} class, specifically testing the
 * {@code findLine} method.
 *
 * <p>This class uses parameterized tests to validate the output of
 * Bresenham's line algorithm for various input points.</p>
 */
class BresenhamLineTest {

    /**
     * Provides test cases for the parameterized test.
     *
     * <p>Each test case includes starting coordinates, ending coordinates,
     * and the expected collection of points that should be generated by the
     * {@code findLine} method.</p>
     *
     * @return a stream of arguments containing test cases
     */
    static Stream<Arguments> linePointsProvider() {
        return Stream.of(Arguments.of(0, 0, 5, 5, List.of(new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4), new Point(5, 5))), Arguments.of(0, 0, 5, 0, List.of(new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(4, 0), new Point(5, 0))),
            Arguments.of(0, 0, 0, 5, List.of(new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(0, 4), new Point(0, 5))), Arguments.of(-2, -2, -5, -5, List.of(new Point(-2, -2), new Point(-3, -3), new Point(-4, -4), new Point(-5, -5))),
            Arguments.of(-1, -1, 2, 2, List.of(new Point(-1, -1), new Point(0, 0), new Point(1, 1), new Point(2, 2))), Arguments.of(2, -1, -1, -4, List.of(new Point(2, -1), new Point(1, -2), new Point(0, -3), new Point(-1, -4))));
    }

    /**
     * Tests the {@code findLine} method of the {@code BresenhamLine} class.
     *
     * <p>This parameterized test runs multiple times with different sets of
     * starting and ending coordinates to validate that the generated points
     * match the expected output.</p>
     *
     * @param x0      the x-coordinate of the starting point
     * @param y0      the y-coordinate of the starting point
     * @param x1      the x-coordinate of the ending point
     * @param y1      the y-coordinate of the ending point
     * @param expected a collection of expected points that should form a line
     */
    @ParameterizedTest
    @MethodSource("linePointsProvider")
    void testFindLine(int x0, int y0, int x1, int y1, Collection<Point> expected) {
        List<Point> actual = BresenhamLine.findLine(x0, y0, x1, y1);
        Assertions.assertEquals(expected.size(), actual.size(), "The size of the points list should match.");
        Assertions.assertTrue(expected.containsAll(actual) && actual.containsAll(expected), "The points generated should match the expected points.");
    }
}
