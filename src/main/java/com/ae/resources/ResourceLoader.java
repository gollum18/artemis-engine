package com.ae.resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

/**
 * This class is responsible for loading in resources from disk when requested.
 * @author Christen Ford
 * @since 08/28/2020
 */
public class ResourceLoader {

    /**
     * Given a ResourceType, this method attempts to load the corresponding JSON resource from disk and return
     * it to the caller.
     * @param resourceType The type of resource to laod.
     * @return A Java Object that is either an org.json.JSONArray or org.json.JSONObject.
     */
    public static Object loadResource(ResourceType resourceType) {
        String filepath = null;
        try {
            Class<?> loaderClass = Class.forName("com.ae.resources.ResourceLoader");
            ClassLoader loader = loaderClass.getClassLoader();
            switch (resourceType) {
                case RS_COMBAT:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.RS_COMBAT_PATH)
                    ).getFile();
                    break;
                case RS_DUNGEONS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.RS_DUNGEONS_PATH)
                    ).getFile();
                    break;
                case RS_OVERWORLD:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.RS_OVERWORLD_PATH)
                    ).getFile();
                    break;
                case RS_SAFEZONES:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.RS_SAFEZONES_PATH)
                    ).getFile();
                    break;
                case ST_CREATURES:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_CREATURES_PATH)
                    ).getFile();
                    break;
                case ST_NPCS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_NPCS_PATH)
                    ).getFile();
                    break;
                case ST_SPELLS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_SPELLS_PATH)
                    ).getFile();
                    break;
                case ST_SPELLBOOKS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_SPELLBOOKS_PATH)
                    ).getFile();
                    break;
                case ST_ARMOR:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_ARMOR_PATH)
                    ).getFile();
                    break;
                case ST_WEAPONS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_WEAPONS_PATH)
                    ).getFile();
                    break;
                case ST_POTIONS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_POTIONS_PATH)
                    ).getFile();
                    break;
                case ST_SCROLLS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_SCROLLS_PATH)
                    ).getFile();
                    break;
                case ST_FACTIONS:
                    filepath = Objects.requireNonNull(
                        loader.getResource(ResourcePaths.ST_FACTIONS_PATH)
                    ).getFile();
            }
        } catch (ClassNotFoundException | NullPointerException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        }
        return readResource(filepath);
    }

    /**
     * Helper method that reads the indicated resource from disk.
     * @param filepath The path to the resource on disk.
     * @return A Java Object that is either an org.json.JSONArray or org.json.JSONObject.
     */
    private static Object readResource(String filepath) {
        Object resource = null;
        try {
            JSONTokener tokener = new JSONTokener(new FileReader(filepath));
            // TODO: This is a bit shifty but it should work to read the root container for now
            try {
                resource = new JSONArray(tokener);
            } catch (JSONException ex) {
                tokener.back();
                resource = new JSONObject(tokener);
            }
        } catch (JSONException | FileNotFoundException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        }
        return resource;
    }

}
