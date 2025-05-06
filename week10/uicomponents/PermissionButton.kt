package com.example.week10.uicomponents

@Composable
fun PermissionButton(
  permission: String,
  label: String,
  onGranted: () -> Unit
){
  val context = LocalContext.current
  val activity = context as Activity

  var showCallDialog by remember{ mutableStateOf(false) }
  var showSettingDialog by remember{ mutableStateOf(false) }

  var showRationaleCheck by remember{ mutableStateOf(false) }
  var showSettingsCheck by remember{ mutableStateOf(false) }

  val launcher = 
    rememberLauncherForActivityResult(
      contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
      if (isGranted) {
        onGranted()
      }else{
        val shouldShowRationale = 
          shouldShowRequestPermissionRationale(
            activity,
            permission
          )
        if (shouldShowRationale) {
          ShowRationaleCheck = true
        } else {
          showSettingsCheck = true
        }
      }
    }

    fun requestPermission() {
      when{
        checkSelfPermission(
          context, permission
        ) == PackageManager.PERMISSION_GRANTED -> {
          onGranted()
        }
        ShowRationaleCheck -> {
          showCallDialog = true
        }
        showSettingsCheck -> {
          showSettingDialog =true
        }
        else -> {
          launcher.launch(permission)
        }
      }
    }

    Button(onClick = {
      requestPermission()
    }, modifier = Modifier.width(200.dp)) {
          Text(label)
    }

    if (showCallDialog) {
        RationaleCallDialog(
            onDismiss = { showCallDialog = false },
            onConfirm = {
                showCallDialog = false
                launcher.launch(permission)
            }
        )
    }
    
    if (showSettingDialog) {
        SettingsCallDialog(
            onDismiss = { showSettingDialog = false },
            onGoToSettings = {
                showSettingDialog = false
                context.startActivity(
                  Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", context.packageName, null)
                  }
                )
            }
        )
    }
}
    
