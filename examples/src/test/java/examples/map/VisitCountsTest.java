package examples.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitCountsTest {
    @Test
    void 存在しないキーには既定値が登録される() {
        var counts = new HashMap<String, Integer>();

        assertEquals(0, VisitCounts.countFor(counts, "/java/list/add"));
        assertEquals(0, counts.get("/java/list/add"));
    }

    @Test
    void 既にあるキーの値は置き換えない() {
        var counts = new HashMap<String, Integer>();
        counts.put("/java/string/equals", 3);

        assertEquals(3, VisitCounts.countFor(counts, "/java/string/equals"));
    }
}

