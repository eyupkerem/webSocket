package com.malkoc.webSocketApp.chatRoom;

import com.malkoc.webSocketApp.user.UserRepository;
import com.malkoc.webSocketApp.user.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createRoomIfNotExist) {

        Optional<ChatRoom> existingRoom = chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId);

        if (existingRoom.isPresent()) {
            log.info("Found existing chat room with ID: {}", existingRoom.get().getChatId());
            return Optional.of(existingRoom.get().getChatId());
        }

        if (createRoomIfNotExist) {
            log.info("Creating new chat room for sender: {} and recipient: {}", senderId, recipientId);
            return Optional.of(createChatId(senderId, recipientId));
        }
            return null;
    }

    public String createChatId(String senderId, String recipientId) {
        try {
            Users sender = userRepository.findByFullName(senderId)
                    .orElseThrow(() -> new RuntimeException("Sender not found: " + senderId));
            Users recipient = userRepository.findByFullName(recipientId)
                    .orElseThrow(() -> new RuntimeException("Recipient not found: " + recipientId));

            String chatId = String.format("chat_%s_%s", sender.getNickName(), recipient.getNickName());
            log.info("Generated chat ID: {}", chatId);

            ChatRoom senderRecipient = ChatRoom.builder()
                    .chatId(chatId)
                    .senderId(senderId)
                    .recipientId(recipientId)
                    .build();

            ChatRoom recipientSender = ChatRoom.builder()
                    .chatId(chatId)
                    .senderId(recipientId)
                    .recipientId(senderId)
                    .build();

            chatRoomRepository.save(senderRecipient);
            chatRoomRepository.save(recipientSender);

            log.info("Successfully created chat room with ID: {}", chatId);
            return chatId;

        } catch (Exception e) {
            log.error("Error creating chat room: ", e);
            throw new RuntimeException("Failed to create chat room", e);
        }
    }
}