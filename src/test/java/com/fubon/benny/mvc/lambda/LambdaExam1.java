package com.fubon.benny.mvc.lambda;

import com.fubon.benny.mvc.domain._common.enums.Color;
import com.fubon.benny.mvc.domain.car.Car;
import com.fubon.benny.mvc.domain.car.dao.CarDao;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaExam1 {

  @Autowired
  private CarDao carDao;

  @Test
  public void exam1()
  {
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    try {
      is = ClassLoader.getSystemResourceAsStream("data/service_log.txt");
      isr = new InputStreamReader(is);
      br = new BufferedReader(isr);
      ////////////////////////////

      // TODO 利用 br.lines 將 log 內容逐行輸出
      Stream<String> lines =br.lines();
      lines.forEach(System.out::println);

      ////////////////////////////
    }
    finally {
      safeClose(br);
      safeClose(isr);
      safeClose(is);
    }
  }

  @Test
  public void exam2()
  {
    // TODO 利用 Stream.generate 隨機印出 10 個 1-100 的值
    Stream.generate(Math::random)
      .map(n->Math.round((n*100)+1))
      .limit(10)
      .forEach(System.out::println);
  }

  @Test
  public void exam3()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請將所有車的 "brand" 用 [,] 串起來 (ex: Toyota,Honda,Nissan,...) (重覆的要去掉)
    String joinName = cars.stream()
      .map(Car::getBrand)
      .distinct()
      .collect(Collectors.joining(","));

    System.out.println(joinName);
  }

  @Test
  public void exam4()
  {
    final List<String> strs = Arrays.asList("1", "2", "3", "4");
    // TODO 請利用 stream 將 List<String> 轉成 String []
    String [] array=strs.stream().toArray(String[]::new);

    System.out.println(Arrays.toString(array));
  }

  @Test
  public void exam5()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    final List<Car> cars2 = new ArrayList<>(cars);
    cars2.removeIf(car -> Color.BLACK.equals(car.getColor()));
    // TODO cars & cars2 在 cars2.removeIf 前與後其數量各為多少 ?

    System.out.println("前："+cars.stream().collect(Collectors.counting()));
    System.out.println("後："+cars2.stream().collect(Collectors.counting()));

  }

  @Test
  public void exam6()
  {
    final List<Long> amts = Arrays.asList(100L, 30L, 88L, 250L, -3L);
    // TODO 請利用 stream, 對 amts 由大到小排序
    List<Long> sortedAmts =amts.stream()
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());

    System.out.println(sortedAmts);
  }

  @Test
  public void exam7()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請利用 stream, 對 cars 進行排序 by color, brand, name
    List<Car> sortedCar = cars.stream()
      .sorted(Comparator.comparing(Car::getColor)
        .thenComparing(Car::getBrand)
        .thenComparing(Car::getName))
      .collect(Collectors.toList());

    System.out.println(sortedCar);
  }

  @Test
  public void exam8()
  {
    final String[] nameArray = new String[]{"jack", "mary", "naomi", "claire", "Dick"};
    // TODO 請輸出所有名字
    Stream.of(nameArray).forEach(System.out::println);

    final List<String> names = Arrays.asList("jack", "mary", "naomi", "claire", "Dick");
    // TODO 請輸出所有名字
    Stream.of(names).flatMap(name->name.stream()).forEach(System.out::println);

  }

  @Test
  public void exam9()
  {
    // TODO 請利用 Stream.iterate 印出 2018/11/01 起的10天(含11/01) (ex: 2018-11-01, 2018-11-02, ...)
    Stream.iterate(LocalDate.of(2018,11,1),localDate -> localDate.plusDays(1L))
      .limit(10)
      .forEach(System.out::println);
  }

  @Test
  public void exam10()
  {
    // TODO 請利用 Stream.iterate 印出 2018/11/01 ~ 2018/11/30 (ex: 2018-11-01, 2018-11-02, ...)
    LocalDate start = LocalDate.parse("2018-11-01"), end = LocalDate.parse("2018-11-30").plusDays(1L);

    Stream.iterate(start,localDate -> localDate.plusDays(1L))
      .limit(ChronoUnit.DAYS.between(start, end))
      .forEach(System.out::println);
  }

  @Test
  public void exam11()
  {
    // TODO 請利用 IntStream.rangeClosed 印出 1~20
    IntStream.rangeClosed(1,20)
      .forEach(System.out::println);
  }

  @Test
  public void exam12()
  {
    final List<Integer> amts = Arrays.asList(1, 3, 7, 2, 4);
    // TODO 請利用 stream 計算有幾個項目
    long number = amts.stream()
      .collect(Collectors.counting());

    System.out.println(number);

    // TODO 請利用 mapToInt & sum 合計 amts
    int sum= amts.stream()
      .mapToInt(Integer::intValue)
      .sum();

    System.out.println(sum);

  }

  @Test
  public void exam13()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請利用 reduce 合計 price (顏色黑色的車請排除 - 不列入合計)
    BigDecimal totalPrice =cars.stream()
      .filter(car -> car.getColor()!=Color.BLACK)
      .map(Car::getPrice)
      //.reduce(BigDecimal.ZERO,(acc,val)->acc.add(val));
      .reduce(BigDecimal.ZERO,BigDecimal::add);

    System.out.println(totalPrice);

  }

  @Test
  public void exam14()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請依車的 brand 進行分組, 結果會是一個 Map<String, List<Car>> 的結構
    Map<String, List<Car>> groupingByBrand =cars.stream()
      .collect(Collectors.groupingBy(Car::getBrand));

    System.out.println(groupingByBrand);
  }

  @Test
  public void exam15()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請利用 stream, 找出 cars 中任一顏色為黑色的車
    Optional blackCar =cars.stream()
      .filter(car->car.getColor()==Color.BLACK).findAny();

    System.out.println(blackCar);
  }

  private void safeClose(Closeable closeable)
  {
    try {
      closeable.close();
    }
    catch (Exception e) {
      // ignore
    }
  }

}
