package com.chenfangming.core;

/**
 * 测试
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-27 12:36
 */
public class Test {


    public static String getData1() throws InterruptedException {
        Thread.sleep(3000);
        return "getData1";
    }

    public static String getData2() throws InterruptedException {
        Thread.sleep(5000);
        return "getData2";
    }

    public static void main(String[] args) throws Exception {
//        long a = System.currentTimeMillis();
//        String data1 = getData1();
//        String data2 = getData2();
//        String result = data1 + data2;
//        long b = System.currentTimeMillis();
//        System.out.println(b - a + ":" + result);
//        ExecutorService executorService = newFixedThreadPool(2);
//        CountDownLatch countDownLatch = new CountDownLatch(2);
//        Future<String> data1Future = executorService.submit(() -> {
//            try {
//                return getData1();
//            } finally {
//                countDownLatch.countDown();
//            }
//        });
//        Future<String> data2Future = executorService.submit(() -> {
//            try {
//                return getData2();
//            } finally {
//                countDownLatch.countDown();
//            }
//        });
//        countDownLatch.await();
//        data1 = data1Future.get();
//        data2 = data2Future.get();
//        long c = System.currentTimeMillis();
//        System.out.println(c - b + ":" + data1 + data2);
//        executorService.shutdown();
//        result = CompletableFuture.supplyAsync(() -> {
//            try {
//                return getData1();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }).thenCombine(CompletableFuture.supplyAsync(() -> {
//                    try {
//                        return getData2();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }), (s1, s2) ->
//                        s1 + s2
//        ).join();
//        long d = System.currentTimeMillis();
//        System.out.println(d - c + ":" + result);
    }

}
