package com.chat.chatapp.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chat.chatapp.dto.ChatResponseData;
import com.chat.chatapp.dto.ChatResponseInnerDetails;

public class ChatUtility {

	public static ChatResponseData getChatData(String chatString) {
		List<ChatResponseInnerDetails> chatHistory = new ArrayList<>();
		ChatResponseInnerDetails crd = new ChatResponseInnerDetails();

		ChatResponseData cresponse = new ChatResponseData();

		List<Map> listOfMaps = new ArrayList<>();

		String megaDataArr[] = chatString.split("@@");
		for (int i = 0; i < megaDataArr.length; i++) {

			String dataArr[] = megaDataArr[i].split("##");

			Map<String, String> retMap = new HashMap<>();
			for (int j = 1; j < dataArr.length; j++) {

				String arr[] = dataArr[j].split("~~");

				crd.setMessage(arr[0]);
				crd.setDate(arr[1]);
				crd.setUserName(arr[2]);
			}
			chatHistory.add(crd);

		}
		cresponse.setChatHistory(chatHistory);
		return cresponse;
	}

}
