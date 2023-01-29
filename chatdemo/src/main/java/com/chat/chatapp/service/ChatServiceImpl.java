package com.chat.chatapp.service;

import java.util.HashMap;
import java.util.Map;

import com.chat.chatapp.dto.ChatRequestData;
import com.chat.chatapp.dto.ChatRequestDto;
import com.chat.chatapp.dto.ChatResponseData;
import com.chat.chatapp.dto.ChatResponseDto;
import com.chat.chatapp.service.core.CoreChatData;
import com.chat.chatapp.service.interfaces.ChatServiceI;
import com.chat.chatapp.service.interfaces.IChatService;
import com.chat.chatapp.service.util.ChatUtility;

public class ChatServiceImpl  implements IChatService{

	

	@Override
	public ChatResponseData addChat(ChatRequestData request) {

		/*ChatServiceI inf = (ChatRequestDto chatData) -> {
			ChatResponseDto crd = new ChatResponseDto();
*/
			Map<String, Object> chatResonseMap = new HashMap<>();
			Map<String, Object> chatDataMap = new HashMap<>();
			CoreChatData core = new CoreChatData();
			try {
				chatResonseMap = core.addChatData(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chatDataMap = core.getChatData(request.getFromUser(), request.getToUser(), request.getDate().toString());

			ChatResponseData chatResponse = new ChatResponseData();
			chatResponse = ChatUtility.getChatData((String) chatDataMap.get("clobData"));

			/*
			 * return chatResponse;
			 * 
			 * }; inf.addChat(request);
			 */

		return chatResponse;
	}

}
