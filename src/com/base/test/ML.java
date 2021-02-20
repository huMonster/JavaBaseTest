package com.base.test;

import java.util.HashMap;
import java.util.Map;

public class ML {
    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

//        @Override
//        public boolean equals(Object obj) {
//            boolean response = false;
//            if(obj instanceof Key){
//                response = (((Key)obj).id).equals(this.id);
//            }
//            return response;
//        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {

        Map<Key, String> m = new HashMap<Key, String>();
        while(true){
            for (int i = 0; i < 10000; i++) {
                if(!m.containsKey(new Key(i))){
                    m.put(new Key(i), "Number" + i);
                }
            }
            System.out.println(m.size());
        }
    }
}
