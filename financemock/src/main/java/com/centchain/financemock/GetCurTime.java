package com.centchain.financemock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurTime
{
  public String CurTime()
  {
    Date day = new Date();
    
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    System.out.println(df.format(day));
    return df.format(day);
  }
  
  public String CurTime1()
  {
    Date day = new Date();
    
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    
    System.out.println(df.format(day));
    return df.format(day);
  }
  
  public String Curday()
  {
    Date day = new Date();
    
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    
    System.out.println(df.format(day));
    return df.format(day);
  }
  
  public String getCurTime()
  {
    Date day = new Date();
    
    SimpleDateFormat df = new SimpleDateFormat("HHmmss");
    
    System.out.println(df.format(day));
    return df.format(day);
  }
}
