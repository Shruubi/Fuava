package CollectionsTests;

import Collections.CollectionUtils;
import Comparator.*;
import Function.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Copyright (c) 2014, Damon
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the author nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * <p/>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class CollectionUtilsTest {
    private CollectionUtils collectionUtils;

    @Before
    public void setup() {
        if(this.collectionUtils == null)
            collectionUtils = new CollectionUtils();
    }

    @Test
    public void testMap() throws Exception {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        List<Integer> result = collectionUtils.map(list, new Function<Integer>() {
            @Override
            public Integer call(Argument[] args) {
                //argument 0 in map will always be the item in the list we are working on
                Integer item = (Integer) args[0].getValue();
                return item + 2;
            }
        });

        for(int i = 0; i < list.size(); i++) {
            assertEquals(Integer.valueOf(list.get(i) + 2), result.get(i));
        }
    }

    @Test
    public void testFilter() throws Exception {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        list = collectionUtils.filter(list, new Comparator<Integer>() {
            @Override
            public boolean compare(Integer val1) {
                return val1 % 2 == 0;
            }
        });

        for(Integer val : list) {
            assertEquals(0, val % 2);
        }
    }

    @Test
    public void testZip() throws Exception {
        List<Integer> lista = new ArrayList<Integer>();
        List<Integer> listb = new ArrayList<Integer>();

        lista.add(1);
        lista.add(2);
        lista.add(3);

        listb.add(4);
        listb.add(5);
        listb.add(6);

        Map<Integer, Integer> result = collectionUtils.zip(lista, listb);

        assertEquals(Integer.valueOf(4), result.get(1));
        assertEquals(Integer.valueOf(5), result.get(2));
        assertEquals(Integer.valueOf(6), result.get(3));
    }
}
