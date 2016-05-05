package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/5/16.
 */
public class SettingsPresenter implements MainContract.BaseSettingsPresenter{
    private final MainContract.BaseSettingsView settingsView;

    public SettingsPresenter(MainContract.BaseSettingsView settingsView) {
        this.settingsView = settingsView;
        this.settingsView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void start() {

    }
}
