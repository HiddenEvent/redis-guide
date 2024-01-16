package org.example.redis;

import redis.clients.jedis.JedisPool;

import java.util.List;

public class SetExam {
    public static void main(String[] args) {
        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try (var jedis = jedisPool.getResource()) {
                //set
                // 추가
                jedis.sadd("users:500:follow", "100", "200", "300", "400", "500");
                // 삭제
                jedis.srem("users:500:follow", "100");
                // 전체 조회
                jedis.smembers("users:500:follow").forEach(System.out::println);
                // 존재 확인
                System.out.println(jedis.sismember("users:500:follow", "200"));
                System.out.println(jedis.sismember("users:500:follow", "120"));
                // 전체 개수
                System.out.println(jedis.scard("users:500:follow"));

            }
        }

    }

}
