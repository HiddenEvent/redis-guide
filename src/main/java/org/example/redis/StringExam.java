package org.example.redis;

import redis.clients.jedis.JedisPool;

public class StringExam {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try (var jedis = jedisPool.getResource()) {
                jedis.set("users:300:email", "ricky@aa.com");
                var value = jedis.get("users:300:email");
                System.out.println(value);
            }
        }
    }
}
