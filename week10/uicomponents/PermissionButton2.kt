package com.example.week10.uicomponents

@Composable
fun PermissionButton2(
  permission: String,
  label: String,
  onGranted: () -> Unit
){
  val context = LocalContext.current
  val activity = context as Activity

  var showRationaleDialog by remember{ mutableStateOf(false) }
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
          showRationaleDialog = true
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

    if (showRationaleDialog) {
        RationaleDialog(
            onDismiss = { showRationaleDialog = false },
            onConfirm = {
                showRationaleDialog = false
                launcher.launch(permission)
            }
        )
    }
    
    if (showSettingDialog) {
        SettingsDialog(
            onDismiss = { showSettingDialog = false },
            onGoToSettings = {
                showSettingDialog = false
                context.startActivity(
                  Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = "package:${context.packageName}".toUri()
                  }
                )
            }
        )
    }
}
    
