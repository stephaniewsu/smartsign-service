package com.example.gtkesh.smartsignservice;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gtkesh on 9/14/15.
 */
public class SmartSignAccessibilityService extends AccessibilityService {
    private static final String TAG = "SmartSign Accessibility Service";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.FLAG_REQUEST_TOUCH_EXPLORATION_MODE;
        AccessibilityManager am = (AccessibilityManager)getSystemService(ACCESSIBILITY_SERVICE);
        Log.i("aeeeeeee ","accessibilityEnabled: " + am.isEnabled() + " touchExplorationEnabled: " + am.isTouchExplorationEnabled());
        final int eventType = event.getEventType();
        String eventText = null;
        Log.d("MESSAGE:", "ON ACCESSIBILITY EVENT CALLED!!!!!!");
        switch(eventType) {
            case AccessibilityEvent.TYPE_VIEW_SCROLLED:
                eventText = "Scrolled: ";
                break;
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                eventText = "Focused: ";
                break;
        }

        eventText = eventText + event.getText();

        // Do something nifty with this text, like speak the composed string
        // back to the user.
        Log.d("EVENT_TEXT", eventText);
    }

    @Override
    public void onInterrupt() {
    }

    @Override
    public void onServiceConnected() {
        // Set the type of events that this service wants to listen to.  Others
        // won't be passed to this service.
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();

        AccessibilityManager am = (AccessibilityManager)getSystemService(ACCESSIBILITY_SERVICE);
        Log.i("ACCESSSSSSS 1","accessibilityEnabled: " + am.isEnabled() + " touchExplorationEnabled: " + am.isTouchExplorationEnabled());

        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED |
                AccessibilityEvent.TYPE_VIEW_FOCUSED;

        // If you only want this service to work with specific applications, set their
        // package names here.  Otherwise, when the service is activated, it will listen
        // to events from all applications.


        // Set the type of feedback your service will provide.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;

        // Default services are invoked only if no package-specific ones are present
        // for the type of AccessibilityEvent generated.  This service *is*
        // application-specific, so the flag isn't necessary.  If this was a
        // general-purpose service, it would be worth considering setting the
        // DEFAULT flag.

        // info.flags = AccessibilityServiceInfo.DEFAULT;

        info.notificationTimeout = 100;
        info.flags = AccessibilityServiceInfo.FLAG_REQUEST_TOUCH_EXPLORATION_MODE;
        am = (AccessibilityManager)getSystemService(ACCESSIBILITY_SERVICE);

        Log.i("ACCESSSSSSS 2","accessibilityEnabled: " + am.isEnabled() + " touchExplorationEnabled: " + am.isTouchExplorationEnabled());

        this.setServiceInfo(info);

    }

    @Override
    protected boolean onGesture(int gestureId) {
        // TODO Auto-generated method stub

        if(gestureId == AccessibilityService.GESTURE_SWIPE_UP_AND_LEFT){
            Log.d("YAAAAAY", "GESTURE DETECTED!");
        }else{
            Log.d("NOOOOOO", "GESTURE WAS NOT DETECTED :(");
        }

        Log.d("onGESTURE",Integer.toString(gestureId));
        return super.onGesture(gestureId);
    }

}
