package com.example.root.newsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
    }

    public static class NewsPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            Preference query = findPreference(getString(R.string.query_key));
            bindPreferenceSummaryToValue(query);

            Preference order = findPreference(getString(R.string.order_by_key));
            bindPreferenceSummaryToValue(order);
        }

        private void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String string = sharedPreferences.getString(preference.getKey(), "");
            onPreferenceChange(preference, string);
        }


        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();

            String stringValue = newValue.toString();


            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);
                if (index >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[index]);
                } else
                    preference.setSummary(stringValue);
                editor.putString(getString(R.string.order_by_key), stringValue);
            } else {
                preference.setSummary(stringValue);
                editor.putString(getString(R.string.query_key), stringValue);
            }
            editor.apply();
            return true;
        }



    }

}
