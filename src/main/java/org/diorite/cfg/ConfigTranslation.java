package org.diorite.cfg;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigTranslation
{
    private final Map<String, String> translations;

    public ConfigTranslation(final Map<String, String> translations)
    {
        this.translations = new HashMap<>(translations);
    }

    public ConfigTranslation(final Properties properties)
    {
        final Map<String, String> translations = new HashMap<>();
        for(final String key : properties.stringPropertyNames())
        {
            translations.put(key, properties.getProperty(key));
        }
        this.translations = new HashMap<>(translations);
    }

    public String get(final String key)
    {
        return this.getOrDefault(key, "MISSING_TRANSLATION_" + key);
    }

    public String getOrDefault(final String key, final String defaultValue)
    {
        return this.translations.getOrDefault(key, defaultValue);
    }
}
