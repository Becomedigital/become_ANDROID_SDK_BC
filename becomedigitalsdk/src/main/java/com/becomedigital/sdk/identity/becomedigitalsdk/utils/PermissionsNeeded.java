package com.becomedigital.sdk.identity.becomedigitalsdk.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionsNeeded extends AppCompatActivity {

    private final String TAG = PermissionsNeeded.class.getSimpleName();
    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    // Permission request codes need to be < 256
    private final int RC_HANDLE_CAMERA_PERM = 2;
    final List<String> permissionsNeeded = new ArrayList<String>();
    private final int REQUEST_PERMISSIONS = 34;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void checkPermissions(final Activity activity, final Button btnPermissions, final LinearLayout lLPermissions) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
            onPermissionsAllowed();
            return;
        }
        PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_PERMISSIONS);
        //Get Permissions
        String[] requestedPermissions = packageInfo.requestedPermissions;

        Boolean show = false;
        for (int i = 0; i < requestedPermissions.length; i++) {
            String requestedPermission = requestedPermissions[i];
            if (!addPermission(permissionsNeeded, requestedPermission)) {
                if (!permissionsNeeded.contains(requestedPermission)) {
                    permissionsNeeded.add(requestedPermission);
                }
            }
        }


        if (requestedPermissions.length > 0) {
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                ArrayList<String> permissionsGroup = new ArrayList<String>();
                for (int i = 0; i < permissionsNeeded.size(); i++) {
                    String permission = permissionsNeeded.get(i);
                    String group = permission;
                    try {
                        if (permission.contains("android.permission.")) {
                            PermissionInfo permissionInfo = getPackageManager().getPermissionInfo(permission, PackageManager.GET_META_DATA);
                            CharSequence charSequence = permissionInfo.loadDescription(getPackageManager());
                            String[] split = permissionInfo.group.split("android.permission-group.");
                            if (split.length > 0) {
                                group = split[split.length - 1];
                            } else {
                                group = permissionInfo.group;
                            }
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "", e);
                    }

                    if (!permissionsGroup.contains(group)) {
                        permissionsGroup.add(group);
                    }

                    if (!ActivityCompat.shouldShowRequestPermissionRationale(activity,
                            permissionsNeeded.get(i))) {
                        show = true;
                    }

                }

                String message =  permissionsGroup.get(0);
                for (int i = 1; i < permissionsGroup.size(); i++) {
                    message = message + ", " + permissionsGroup.get(i);
                }


                if (show) {
                    ActivityCompat.requestPermissions(activity, permissionsNeeded.toArray(new String[permissionsNeeded.size()]), REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
               } else {
                    lLPermissions.setVisibility(View.VISIBLE);
                    btnPermissions.setOnClickListener(v -> ActivityCompat.requestPermissions(activity, permissionsNeeded.toArray(new String[permissionsNeeded.size()]), REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS));
                }

                return;
            }else{
            }
            return;
        }
    }


    private boolean addPermission(List<String> permissionsList, String permission) {


        if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED || permission == Manifest.permission.READ_PHONE_STATE) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission))
                return false;
        }
        return true;


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onPermissionsAllowed() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onPermissionsRequired(Button btnPermissions, LinearLayout lLPermissions) {
        // Permission Denied
        lLPermissions.setVisibility(View.VISIBLE);
        btnPermissions.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                try {
                    checkPermissions(  PermissionsNeeded.this, btnPermissions, lLPermissions);
                } catch (PackageManager.NameNotFoundException e) {

                    e.printStackTrace();
                }
            }
        });
    }

    public void requestCameraPermission(Activity activity) {
        Log.w(TAG, "Camera permission is not granted. Requesting permission");

        final String[] permissions = new String[]{Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);

    }

    public void showPermissionsRequestCamera(final Activity activity) {
        requestCameraPermission(activity);

    }


}
