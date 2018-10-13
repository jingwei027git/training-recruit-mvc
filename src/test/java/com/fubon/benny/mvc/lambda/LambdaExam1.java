package com.fubon.benny.mvc.lambda;

import com.fubon.benny.mvc.domain._common.enums.Color;
import com.fubon.benny.mvc.domain.car.Car;
import com.fubon.benny.mvc.domain.car.dao.CarDao;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
  }

  @Test
  public void exam3()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請將所有車的 "brand" 用 [,] 串起來 (ex: Toyota,Honda,Nissan,...) (重覆的要去掉)
  }

  @Test
  public void exam4()
  {
    final List<String> strs = Arrays.asList("1", "2", "3", "4");
    // TODO 請利用 stream 將 List<String> 轉成 String []
  }

  @Test
  public void exam5()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    final List<Car> cars2 = new ArrayList<>(cars);
    cars2.removeIf(car -> Color.BLACK.equals(car.getColor()));
    // TODO cars & cars2 在 cars2.removeIf 前與後其數量各為多少 ?
  }

  @Test
  public void exam6()
  {
    final List<Long> amts = Arrays.asList(100L, 30L, 88L, 250L, -3L);
    // TODO 請利用 stream, 對 amts 由大到小排序  
  }

  @Test
  public void exam7()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請利用 stream, 對 cars 進行排序 by color, brand, name  
  }

  @Test
  public void exam8()
  {
    final String[] nameArray = new String[]{"jack", "mary", "naomi", "claire", "Dick"};
    // TODO 請輸出所有名字
    Stream.of(nameArray)
    ;

    final List<String> names = Arrays.asList("jack", "mary", "naomi", "claire", "Dick");
    // TODO 請輸出所有名字
    Stream.of(names)
    ;
  }

  @Test
  public void exam9()
  {
    // TODO 請利用 Stream.iterate 印出 2018/11/01 起的10天(含11/01) (ex: 2018-11-01, 2018-11-02, ...)
  }

  @Test
  public void exam10()
  {
    // TODO 請利用 Stream.iterate 印出 2018/11/01 ~ 2018/11/30 (ex: 2018-11-01, 2018-11-02, ...)
  }

  @Test
  public void exam11()
  {
    // TODO 請利用 IntStream.rangeClosed 印出 1~20
  }

  @Test
  public void exam12()
  {
    final List<Integer> amts = Arrays.asList(1, 3, 7, 2, 4);
    // TODO 請利用 stream 計算有幾個項目

    // TODO 請利用 mapToInt & sum 合計 amts

  }

  @Test
  public void exam13()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請利用 reduce 合計 price (顏色黑色的車請排除 - 不列入合計)
  }

  @Test
  public void exam14()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請依車的 brand 進行分組, 結果會是一個 Map<String, List<Car>> 的結構
  }

  @Test
  public void exam15()
  {
    final List<Car> cars = carDao.getJpa().findAll();
    // TODO 請利用 stream, 找出 cars 中任一顏色為黑色的車
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
