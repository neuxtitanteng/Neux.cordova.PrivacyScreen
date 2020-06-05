package com.neux.privacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 *  private when shown in the task switcher
 */
public class PrivacyScreen extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Activity activity = this.cordova.getActivity();
    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
  }

  @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      if (action.equals("addPrivacyScreen")) {
        this.addPrivacyScreen();
        return true;
      } else if (action.equals("removePrivacyScreen")) {
        this.removePrivacyScreen();
        return true;
      }
      return false;
    }

    private  void addPrivacyScreen() {
      cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
              cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
              System.out.println("Screen will not be kept on. Cancel KeepScreenOn");
          }
      });
      // this.cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
      // Activity activity = this.cordova.getActivity();
      // Window window = activity.getWindow();
      // WindowManager wm = activity.getWindowManager();
      // window.addFlags(WindowManager.LayoutParams.FLAG_SECURE);
      // wm.removeViewImmediate(window.getDecorView());
      // wm.addView(window.getDecorView(), window.getAttributes());
    }
    
    private void removePrivacyScreen() {
      cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
              cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
              System.out.println("Screen will not be kept on. Cancel KeepScreenOn");
          }
      });
      // this.cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
      // Activity activity = this.cordova.getActivity();
      // Window window = activity.getWindow();
      // WindowManager wm = activity.getWindowManager();
      // // window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
      // wm.removeViewImmediate(window.getDecorView());
      // wm.addView(window.getDecorView(), window.getAttributes());
    }
}