package com.beta.replyservice.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service("replyServiceImplV2")
public class ReplyServiceImplV2 implements ReplyService {

  @Override
  public String processMessage(String message) {
    String[] tokens = message.split("-");
    String commands = tokens[0];
    String resMessage = tokens[1];

    for (byte b : commands.getBytes()) {
      if (b == '1') {
        resMessage = reverse(resMessage);
      } else {
        resMessage = md5(resMessage);
      }
    }
    return resMessage;
  }

  protected String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  protected String md5(String s) {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException ignore) {
      // can't happen. MD5 algorithm always exists
    }
    byte[] inputBytes = s.getBytes(StandardCharsets.UTF_8);
    byte[] outputMd5 = md.digest(inputBytes);
    BigInteger bigInteger = new BigInteger(1, outputMd5);
    return String.format("%0" + (outputMd5.length << 1) + "x", bigInteger);
  }
}
