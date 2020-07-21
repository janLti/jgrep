package org.altenter.jgrep;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

class JgrepTest {

    @Test
    void getSearchStrings() {
        List<String> searches= Jgrep.getSearchStrings("testsearch","file");
        assertEquals(1, searches.size());
    }
}