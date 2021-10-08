package id.ac.umn.dimas.uts_41281;

import java.util.ArrayList;

public class SfxData {
    private static String[] sfxNames = {
            "Air Raid",
            "Police Siren",
            "Electric Guitar",
            "Guitar",
    };

    private static String[] sfxCategories = {
            "Emergency",
            "Emergency",
            "Instrument",
            "Instrument",
    };

    private static int[] sfxSources = {
            R.raw.emergency_air_raid,
            R.raw.emergency_police_siren,
            R.raw.instrument_electric_guitar,
            R.raw.instrument_guitar,
    };

    static ArrayList<Sfx> getSfxList() {
        ArrayList<Sfx> list = new ArrayList<>();

        for (int position = 0; position < sfxNames.length; position++) {
            String sfxName = sfxNames[position];
            String sfxCategory = sfxCategories[position];
            int sfxSource = sfxSources[position];

            Sfx sfx = new Sfx(sfxName, sfxCategory, sfxSource);

            list.add(sfx);
        }

        return list;
    }
}
