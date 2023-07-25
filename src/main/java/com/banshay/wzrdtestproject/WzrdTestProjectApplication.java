package com.banshay.wzrdtestproject;

import com.banshay.wzrd.EnableWzrd;
import com.banshay.wzrd.WzrdService;
import com.banshay.wzrdtestproject.db.Color;
import com.banshay.wzrdtestproject.db.ColorService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@EnableWzrd
@RestController
@EnableJdbcRepositories
@RequiredArgsConstructor
@SpringBootApplication
public class WzrdTestProjectApplication {

    private final ColorService colorService;
    private final WzrdService wzrdService;

    @GetMapping("/wzrd/multiply/{number}")
    public Integer wzrdMultiply(@PathVariable Integer number) {
        return wzrdService.powerOfTwo(number);
    }

    @GetMapping("/multiply/{number}")
    public Integer multiply(@PathVariable Integer number) {
        return number * number;
    }

    @GetMapping("/wzrd/color/{id}")
    public String wzrdGetColor(@PathVariable Long id) {
        return wzrdService.loadColor(id, colorService);
    }

    @GetMapping("/color/{id}")
    public String getColor(@PathVariable Long id) {
        val color = colorService.getColorById(id);
        if (color != null) {
            if (Objects.equals(color.color(), "Yellow")) {
                return "You got the best color: %s".formatted(color.color());
            }
            return color.color();
        }
        return "Color not found";
    }

    public static void main(String[] args) {
        SpringApplication.run(WzrdTestProjectApplication.class, args);
    }

}
