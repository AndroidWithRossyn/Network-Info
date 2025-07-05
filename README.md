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
- [The 5 Biggest Financial Crashes in History — and What They All Have in Common](https://rohitrajkhorwal.medium.com/the-5-biggest-financial-crashes-in-history-and-what-they-all-have-in-common-2d87c29eae22?source=rss-40883ee5aa3e------2)
- [15 Things Poor People Do That the Rich Don’t](https://rohitrajkhorwal.medium.com/15-things-poor-people-do-that-the-rich-dont-ad24458a59ca?source=rss-40883ee5aa3e------2)
- [The ‘rich getting richer’ Argument](https://rohitrajkhorwal.medium.com/the-rich-getting-richer-argument-af546d1f22af?source=rss-40883ee5aa3e------2)
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