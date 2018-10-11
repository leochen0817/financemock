package com.centchain.financemock;

import java.util.UUID;

public class GenerateUuid
{
  public static String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  
  public String generate8ShortUuid()
  {
    StringBuffer shortBuffer = new StringBuffer();
    String uuid = UUID.randomUUID().toString().replace("-", "");
    for (int i = 0; i < 8; i++)
    {
      String str = uuid.substring(i * 4, i * 4 + 4);
      int x = Integer.parseInt(str, 16);
      shortBuffer.append(chars[(x % 62)]);
    }
    return shortBuffer.toString();
  }
  
  public String generate17Uuid()
  {
    StringBuffer shortBuffer = new StringBuffer();
    String uuid = UUID.randomUUID().toString().replace("-", "");
    for (int i = 0; i < 8; i++)
    {
      String str = uuid.substring(i * 4, i * 4 + 4);
      int x = Integer.parseInt(str, 16);
      shortBuffer.append(chars[(x % 62)]);
    }
    return "623185000" + shortBuffer.toString();
  }
  
  public static String get36UUID()
  {
    String uuid = UUID.randomUUID().toString();
    
    return uuid;
  }
  
  public static String get32UUID()
  {
    String uuid = UUID.randomUUID().toString();
    
    return uuid.replaceAll("-", "");
  }
  
  public static String get16UUId()
  {
    int machineId = 1;
    int hashCodeV = UUID.randomUUID().toString().hashCode();
    if (hashCodeV < 0) {
      hashCodeV = -hashCodeV;
    }
    return machineId + String.format("%015d", new Object[] { Integer.valueOf(hashCodeV) });
  }
}
