package com.banshay.wzrdtestproject;

import com.banshay.wzrd.WzrdEnabled;
import com.banshay.wzrd.WzrdService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@WzrdEnabled
@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class WzrdTestProjectApplication {

  private final WzrdService wzrdService;

  @GetMapping("/multiply/{number}")
  public Mono<Integer> multiply(@PathVariable Integer number) {
    return wzrdService.powerOfTwo(number);
  }

  public static void main(String[] args) {
    SpringApplication.run(WzrdTestProjectApplication.class, args);
  }

}
