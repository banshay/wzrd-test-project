package com.banshay.wzrdtestproject.db;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColorService {

  private final ColorRepository colorRepository;

  public Color getColorById(Long id){
    log.debug("loading color with id {}", id);
    return colorRepository.findById(id).orElse(null);
  }
}
