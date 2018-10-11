package com.centchain.financemock;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;


@RestController
public class FinancemockController {
	private static final Logger logger = LoggerFactory.getLogger(FinancemockController.class);
	
	@RequestMapping(value="test")
	public @ResponseBody String test() {
		return "{\"retCode\":\"0000\",\"retMsg\":\"交易成功\",\"data\":{\"orderNo\":\"1809290406000012\"}}";
	}
	

	  @RequestMapping(value={"/financemock"}, method=RequestMethod.POST, consumes={"application/json"})
	  @ResponseBody
	  public String sendResponse(HttpServletRequest request)
	    throws IOException{
		  InputStream inputStream = request.getInputStream();
		  String jsonResult = (String)((Stream)new BufferedReader(new InputStreamReader(inputStream)).lines().parallel()).collect(Collectors.joining(System.lineSeparator()));
		  logger.info("==========financemock请求==========" + jsonResult);
		  JsonParser parse = new JsonParser();
		  
		  JsonElement jsonElement = parse.parse(jsonResult);
	      JsonObject jsonObject = jsonElement.getAsJsonObject();
	      JsonPrimitive TransCode = jsonObject.getAsJsonPrimitive("TransCode");
	      JsonPrimitive MerchantSeq = jsonObject.getAsJsonPrimitive("MerchantSeq");
	      JsonPrimitive MerchantId = jsonObject.getAsJsonPrimitive("MerchantId");
	      String transCode = TransCode.getAsString();
	      if (transCode.equals("QR2301")){
	    	  MerchantSeq = jsonObject.getAsJsonPrimitive("MerchantSeq");
	          String merchantSeq = MerchantSeq.getAsString();
	          
	          MerchantId = jsonObject.getAsJsonPrimitive("MerchantId");
	          String merchantId = MerchantId.getAsString();
	          String result = new QR2301().mockResp(transCode,merchantSeq,merchantId);
	          logger.info("==========financemock响应==========" + result);
	          return result;
	      }
	      if (transCode.equals("QR2302")){
	    	  MerchantSeq = jsonObject.getAsJsonPrimitive("MerchantSeq");
	          String merchantSeq = MerchantSeq.getAsString();
	          
	          MerchantId = jsonObject.getAsJsonPrimitive("MerchantId");
	          String merchantId = MerchantId.getAsString();
	          String result = new QR2302().mockResp(transCode,merchantSeq,merchantId);
	          logger.info("==========financemock响应==========" + result);
	          return result;
	      }
		  
		  return "000000";
	  }

	
	
}
