package com.chat.chatapp.service;

import java.util.HashMap;
import java.util.Map;

import com.chat.chatapp.dto.ChatRequestDto;
import com.chat.chatapp.dto.ChatResponseDto;
import com.chat.chatapp.service.core.CoreChatData;
import com.chat.chatapp.service.interfaces.ChatServiceI;
import com.chat.chatapp.service.util.ChatUtility;

public class ImplChatServices  implements ChatServiceI{

	

	@Override
	public ChatResponseDto addChat(ChatRequestDto request) {

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

			ChatResponseDto chatResponse = new ChatResponseDto();
			chatResponse = ChatUtility.getChatData((String) chatDataMap.get("clobData"));

			/*
			 * return chatResponse;
			 * 
			 * }; inf.addChat(request);
			 */

		return chatResponse;
	}

}
