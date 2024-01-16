package org.example.redis;

import redis.clients.jedis.JedisPool;

import java.util.List;

public class StringExam {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try (var jedis = jedisPool.getResource()) {
                jedis.set("users:300:email", "ricky@aa.com");
                jedis.set("users:300:name", "kim");
                jedis.set("users:300:age", "32");

                /*get => 단일 키를 조회하는 명령어*/
                var email = jedis.get("users:300:email");
                System.out.println(email);

                /*mget => 여러개의 키를 동시에 조회하는 명령어*/
                List<String> UserInfo = jedis.mget("users:300:email", "users:300:name", "users:300:age");
                UserInfo.forEach(System.out::println);

                /*incr => 숫자를 1씩 증가시키는 명령어*/
                long counter = jedis.incr("counter");
                System.out.println(counter);

                /*incrBy => 숫자를 지정한 만큼 증가시키는 명령어*/
                long counter2 = jedis.incrBy("counter", 10L);
                System.out.println(counter2);

                /*decr => 숫자를 1씩 감소시키는 명령어*/
                long counter3 = jedis.decr("counter");
                System.out.println(counter3);

                /*decrBy => 숫자를 지정한 만큼 감소시키는 명령어*/
                long counter4 = jedis.decrBy("counter", 20L);
                System.out.println(counter4);

                /*pipeline=> 여러개의 명령어를 한번에 실행하는 명령어
                 (pipeline을 사용하면 네트워크 비용을 줄일 수 있다.)*/
                var pipeline = jedis.pipelined();
                pipeline.set("users:400:email", "400@aa.com");
                pipeline.set("users:400:name", "kim 4");
                pipeline.set("users:400:age", "40");
                List<Object> objects = pipeline.syncAndReturnAll();
                objects.forEach(System.out::println);

            }
        }
    }
}
