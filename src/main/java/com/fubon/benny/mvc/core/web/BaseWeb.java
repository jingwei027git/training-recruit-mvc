package com.fubon.benny.mvc.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.*;

public abstract class BaseWeb {

  @Getter
  @Setter(AccessLevel.PROTECTED)
  @Autowired
  private HttpServletRequest request;

  @Getter
  @Setter(AccessLevel.PROTECTED)
  @Autowired
  private HttpServletResponse response;

}
