package com.telegram.tubegram.command;

import com.telegram.api.ICommandProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.Function;

/**
 * Search events by specific category
 */
@Slf4j
@Component
public class StartCommand extends ICommandProcessor {

    private final static String COMMAND = "start";

    @Override
    public void process(Update update, Function<PartialBotApiMethod<Message>, PartialBotApiMethod<Message>> callback) {
        SendMessage sendMessage = createSendMessage(getMessage(update).getChatId(), "Please set link on youtube video to get subtitles");
        callback.apply(sendMessage);
    }

    @Override
    public String getCommand() {
        return COMMAND;
    }
}
