# Network Connectivity Utility

A lightweight, reliable utility for Android applications to check and monitor network connectivity status.


<div align="start">
  
<a href="mailto:banrossyn@gmail.com"><img src="https://img.shields.io/badge/Gmail-EA4335.svg?logo=Gmail&logoColor=white"></a>

</div>

### Features

- Check if device is connected to any network (WiFi, Cellular, Ethernet, etc.)
- Determine the specific type of network connection
- Register for real-time network state change callbacks
- Support for Android API levels from 16 to the latest
- Proper null safety handling
- Validation that internet connection actually works

### Installation

Add the required permission to your `AndroidManifest.xml`:

```xml 
<uses-permission android:name="android.permission.INTERNET" /> 
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

### Usage

### Basic Connectivity Check

```kotlin
if (context.isNetworkConnected()) {
    // Network is available
} else {
    // No network connection
}
```

### Get Network Connection Type

```kotlin
when (context.getNetworkType()) {
    NetworkType.WIFI -> // Connected to WiFi
    NetworkType.CELLULAR -> // Connected to mobile data
    NetworkType.ETHERNET -> // Connected to ethernet
    NetworkType.BLUETOOTH -> // Connected via Bluetooth
    NetworkType.VPN -> // Connected through VPN
    NetworkType.NONE -> // No connection
}
```

### Monitor Network Changes

```kotlin
// For API level 21 and above
val networkCallback = context.registerNetworkCallback(
    onAvailable = {
        // Network became available
    },
    onLost = {
        // Network connection lost
    }
)

// Don't forget to unregister when done
context.unregisterNetworkCallback(networkCallback)
```

### Best Practices

- Consider using this utility with LiveData or Flow to create reactive UI updates
- For operations that require network, check connectivity first to provide better user experience
- Implement retry mechanisms for network operations when connectivity is restored

### Find this Repository useful? ❤️

Support it by joining stargazers for this repository. ⭐

Also, [follow me on GitHub](https://github.com/AndroidWithRossyn/) for my next creations! 🤩



### :zap: Latest Medium Articles

<!-- ARTICLES:START -->
- [Apply for Access to Production: Your App on the Google Play Store](https://rohitrajkhorwal.medium.com/apply-for-access-to-production-your-app-on-the-google-play-store-3af6736f1e68?source=rss-40883ee5aa3e------2)
- [Sign Your Git Commits for GitHub](https://rohitrajkhorwal.medium.com/sign-your-git-commits-for-github-47c7a589c2c3?source=rss-40883ee5aa3e------2)
- [Network Connectivity in Android — Kotlin](https://rohitrajkhorwal.medium.com/network-connectivity-in-android-kotlin-7bd3c3adee13?source=rss-40883ee5aa3e------2)
- [Android SMS Permissions : Understanding the Security Risks](https://rohitrajkhorwal.medium.com/android-sms-permissions-be33fe30ee41?source=rss-40883ee5aa3e------2)
- [Say Goodbye to Toast: A Better Way to Show Messages in Your Android App](https://rohitrajkhorwal.medium.com/say-goodbye-to-toast-a-better-way-to-show-messages-in-your-android-app-58622a6578a2?source=rss-40883ee5aa3e------2)
<!-- ARTICLES:END -->

### License

```
Copyright 2025 Rossyn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=60&section=footer"/>
</p>