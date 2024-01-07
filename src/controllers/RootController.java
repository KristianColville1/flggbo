package controllers;

import views.LoginView;
import views.RootView;

public class RootController {
    private RootView rootView;

    public RootController(RootView rootView) {
        this.rootView = rootView;
    }

    public void handleEnterAction() {
        rootView.clearView();
        new LoginView(rootView, () -> rootView.returnToRoot());
    }
}
