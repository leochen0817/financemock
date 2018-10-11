package com.centchain.financemock;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class QR2302
{
//	public String mockResp(String transCode, String merchantSeq, String merchantId) {
//		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("merchantId", merchantId);
//		map.put("merchantSeq", merchantSeq);
//		map.put("platTransTime", new GetCurTime().CurTime1());
//		map.put("platformSeq", GenerateUuid.get32UUID());
//		map.put("respCode", "000000");
//		map.put("respMsg", "交易成功");
//		map.put("respSignature", GenerateUuid.get32UUID());
//		map.put("transCode", transCode);
//		map.put("version", "0000");
//		return gson.toJson(map);
//	}
	
	public String mockResp(String transCode, String merchantSeq, String merchantId) {
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		Map<String, String> map = new HashMap<String, String>();
		map.put("MerchantId", merchantId);
		map.put("MerchantSeq", merchantSeq);
		map.put("PlatTransTime", new GetCurTime().CurTime1());
		map.put("PlatformSeq", GenerateUuid.get32UUID());
		map.put("RespCode", "000000");
		map.put("RespMsg", "交易成功");
		map.put("RespSignature", GenerateUuid.get32UUID());
		map.put("TransCode", transCode);
		map.put("Version", "0000");
		map.put("BindNumber", "1");
		map.put("FullBindNumber", "6217882018093012349");
		return gson.toJson(map);
	}
}
