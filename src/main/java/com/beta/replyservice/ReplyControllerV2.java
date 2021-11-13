package com.beta.replyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.beta.replyservice.service.ReplyService;

@RestController
public class ReplyControllerV2 {

  private static final String VALID_INPUT_PATTERN = "^[12]*-[a-z0-9]*$";

  @Autowired
  @Qualifier("replyServiceImplV2")
  private ReplyService replyService;

  @GetMapping("/v2/reply")
  public ReplyMessage replying() {
    return new ReplyMessage("Message is empty");
  }

  @GetMapping("/v2/reply/{message}")
  public ReplyMessage replying(@PathVariable String message) {
    if (!message.matches(VALID_INPUT_PATTERN)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input");
    }

    String resMessage = replyService.processMessage(message);
    return new ReplyMessage(resMessage);
  }

}
