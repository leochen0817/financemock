package com.centchain.financemock;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class QR2301{
	
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
		return gson.toJson(map);
	}
}
