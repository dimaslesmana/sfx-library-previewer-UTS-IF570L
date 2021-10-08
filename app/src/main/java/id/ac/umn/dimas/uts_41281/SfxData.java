package id.ac.umn.dimas.uts_41281;

import java.util.ArrayList;

public class SfxData {
    private static ArrayList<Sfx> sfxList = new ArrayList<>();

    private static String[] sfxNames = {
            "Air Raid",
            "Police Siren",
            "Electric Guitar",
            "Guitar",
            "Bowling",
    };

    private static String[] sfxCategories = {
            "Emergency",
            "Emergency",
            "Instrument",
            "Instrument",
            "Sport",
    };

    private static int[] sfxSources = {
            R.raw.emergency_air_raid,
            R.raw.emergency_police_siren,
            R.raw.instrument_electric_guitar,
            R.raw.instrument_guitar,
            R.raw.sport_bowling,
    };

    static void initialize() {
        sfxList.clear();

        for (int position = 0; position < sfxNames.length; position++) {
            String sfxName = sfxNames[position];
            String sfxCategory = sfxCategories[position];
            int sfxSource = sfxSources[position];

            Sfx sfx = new Sfx(sfxName, sfxCategory, sfxSource);

            sfxList.add(sfx);
        }
    }

    static ArrayList<Sfx> getSfxList() {
        return sfxList;
    }
}
