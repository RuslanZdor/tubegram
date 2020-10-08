package com.telegram.tubegram.command;

import com.telegram.api.ICommandProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;
import java.util.function.Function;

/**
 * Show top 10 events provided by PredictHQ API
 */
@Slf4j
@Component
public class ShowSubtitlesCommand extends ICommandProcessor {

    private final static String COMMAND = "event";

    @Override
    public void process(Update update, Function<PartialBotApiMethod<Message>, PartialBotApiMethod<Message>> callback) {
    }

    private static Optional<String> getId(String text) {
        String[] words = splitMessage(text);
        if (words.length < 2 || words[1].length() == 0) {
            return Optional.empty();
        }
        return Optional.of(words[1]);
    }

    @Override
    public String getCommand() {
        return COMMAND;
    }

}
