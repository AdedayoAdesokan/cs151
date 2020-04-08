import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArraysTest {
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test1() {
        // fail("Not yet implemented");
        int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
        Arrays.swapLargestAndSmallest(a);
        int[] aSwapped = new int[] { 5, 4, 9, 1, 2, 6 };
        assertArrayEquals(aSwapped, a);
    }

    @Test
    void test2() {
        int[] a = new int[] { 1, 4, 1, 9, 2, 6 };
        Arrays.swapLargestAndSmallest(a);
        int[] aSwapped = new int[] { 9, 4, 1, 1, 2, 6 };
        assertArrayEquals(aSwapped, a);
    }

    @Test
    void test3() {
        int[] a = new int[] { 1, 4, 2, 9, 9, 6 };
        Arrays.swapLargestAndSmallest(a);
        int[] aSwapped = new int[] { 9, 4, 2, 1, 9, 6 };
        assertArrayEquals(aSwapped, a);
    }

    @Test
    void test4() {
        int[] a = new int[] { 1 };
        Arrays.swapLargestAndSmallest(a);
        int[] aSwapped = new int[] { 1 };
        assertArrayEquals(aSwapped, a);
    }
}
