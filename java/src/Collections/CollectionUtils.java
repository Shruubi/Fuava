package Collections;

import Comparator.Comparator;
import Function.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

public class CollectionUtils implements ICollectionUtils {
    @Override
    public <RETURN, LISTTYPE> List<RETURN>
    map(List<LISTTYPE> list, Function<RETURN> func) {
        List<RETURN> values = new LinkedList<RETURN>();

        for(LISTTYPE item : list) {
            Argument argument = Arg.makeArgument(item);
            RETURN result = func.call(new Argument[] {argument});
            values.add(result);
        }

        return values;
    }

    @Override
    public <LISTTYPE> List<LISTTYPE>
    filter(List<LISTTYPE> list, Comparator<LISTTYPE> comparator) {
        List<LISTTYPE> result = new LinkedList<LISTTYPE>();

        for(LISTTYPE item : list) {
            if(comparator.compare(item)) {
                result.add(item);
            }
        }

        return result;
    }

    @Override
    public <LISTATYPE, LISTBTYPE>
    Map<LISTATYPE, LISTBTYPE> zip(List<LISTATYPE> listA, List<LISTBTYPE> listB) {
        Map<LISTATYPE, LISTBTYPE> result = new HashMap<LISTATYPE, LISTBTYPE>();

        for(int i = 0; i < listA.size() && i < listB.size(); i++) {
            result.put(listA.get(i), listB.get(i));
        }

        return result;
    }


}
