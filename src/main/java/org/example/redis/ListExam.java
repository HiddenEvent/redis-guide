package org.example.redis;

import redis.clients.jedis.JedisPool;

import java.util.List;

public class ListExam {
    public static void main(String[] args) {
        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try (var jedis = jedisPool.getResource()) {
                //list
                // 1. stack
                jedis.rpush("stack1", "aaa");
                jedis.rpush("stack1", "bbb");
                jedis.rpush("stack1", "ccc");
                /*
                List<String> stack1 = jedis.lrange("stack1", 0, -1);
                stack1.forEach(System.out::println);
                */
                System.out.println(jedis.rpop("stack1"));
                System.out.println(jedis.rpop("stack1"));
                System.out.println(jedis.rpop("stack1"));


                // 2. queue
                // 3. blocking queue

            }
        }

    }

}
