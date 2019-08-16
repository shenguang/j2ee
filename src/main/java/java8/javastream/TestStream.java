package java8.javastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @className TestStream
 * @Description
 * @Date 2019/8/12 9:07
 * @Author shenguang
 * @Version 1.0
 **/
public class TestStream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();  //获取一个顺序流

        Stream<String> parallelStream = list.parallelStream();  //获取一个并行流,在操作耗时时使用

        //2.通过Arrays中的steam()获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);
        //3.通过stream类中静态方法of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);
        //4.创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
        System.out.println("======stream3=======");
        stream3.forEach(System.out::println);
        System.out.println("======stream4=======");
        //生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);
    }
}
