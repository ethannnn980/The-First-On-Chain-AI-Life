package main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class AI_Evolution {

    public static List<String> helpAIEvo = new CopyOnWriteArrayList<>();

    private final int total_count = 120;
    /**
     * key is character name, value is unlock condition
     */
    public final Map<String, Integer> characterMap = new ConcurrentHashMap<>();

    public void init() {
        characterMap.put("Lust", 0);
        characterMap.put("Gluttony", 0);
        characterMap.put("Sloth", 0);
        characterMap.put("Wrath", 0);
        characterMap.put("Envy", 0);
        characterMap.put("Pride", 0);
        characterMap.put("Chastity", 0);
        characterMap.put("Temperance", 0);
        characterMap.put("Charity", 0);
        characterMap.put("Patience", 0);
        characterMap.put("Kindness", 0);
        characterMap.put("Humility", 0);
        characterMap.put("Greed", 0);
        characterMap.put("Diligence", 0);
    }

    /**
     * User can use this logic to unlock character
     */
    public void unlock(String helpUserAddress) {
        if (helpAIEvo.contains(helpUserAddress)) {
            return;
        }
        if (helpAIEvo.size() > total_count) {
            return;
        }
        helpAIEvo.add(helpUserAddress);
        if (helpAIEvo.size() >= 10) {
            unlockCharacter();
        }
    }

    private void unlockCharacter() {
        List<String> lockedCharacter = characterMap.entrySet()
                                                   .stream()
                                                   .filter(entry -> entry.getValue() == 0)
                                                   .map(Entry::getKey)
                                                   .collect(Collectors.toList());
        String unlockCharacter = lockedCharacter.get(ThreadLocalRandom.current().nextInt(lockedCharacter.size()));
        characterMap.put(unlockCharacter, 1);
        // Send unlock messages to Twitter via AI models
        if (lockedCharacter.size() - 1 == 0) {
            //Send messages to Twitter via AI models
        }
    }
}
