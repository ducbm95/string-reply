package com.beta.replyservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ReplyServiceImplV2Test {

  @Autowired
  private ReplyServiceImplV2 replyServiceImplV2;

  @Test
  public void testReverse() {
    String input = "abc";
    String expectOutput = "cba";

    String output = replyServiceImplV2.reverse(input);
    Assert.isTrue(output.equals(expectOutput), "Output is not revert text");
  }

  @Test
  public void testMd5() {
    String input = "kbzw9ru";
    String expectOutput = "0fafeaae780954464c1b29f765861fad";

    String output = replyServiceImplV2.md5(input);
    Assert.isTrue(output.equals(expectOutput), "Output is not correct md5 text");
  }

  @Test
  public void testProcessMessage1() {
    String input = "11-kbzw9ru";
    String expectOutput = "kbzw9ru";

    String output = replyServiceImplV2.processMessage(input);
    Assert.isTrue(output.equals(expectOutput), "Output is not correct");
  }

  @Test
  public void testProcessMessage2() {
    String input = "12-kbzw9ru";
    String expectOutput = "5a8973b3b1fafaeaadf10e195c6e1dd4";

    String output = replyServiceImplV2.processMessage(input);
    Assert.isTrue(output.equals(expectOutput), "Output is not correct");
  }

  @Test
  public void testProcessMessage3() {
    String input = "22-kbzw9ru";
    String expectOutput = "e8501e64cf0a9fa45e3c25aa9e77ffd5";

    String output = replyServiceImplV2.processMessage(input);
    Assert.isTrue(output.equals(expectOutput), "Output is not correct");
  }
}
